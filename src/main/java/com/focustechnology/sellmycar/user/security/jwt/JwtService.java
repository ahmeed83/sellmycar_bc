package com.focustechnology.sellmycar.user.security.jwt;

import com.focustechnology.sellmycar.user.repository.PersonRepository;
import com.focustechnology.sellmycar.user.repository.domain.Admin;
import com.focustechnology.sellmycar.user.repository.domain.Customer;
import com.focustechnology.sellmycar.user.repository.domain.Dealer;
import com.focustechnology.sellmycar.user.repository.domain.Login;
import com.focustechnology.sellmycar.user.repository.domain.Person;
import com.focustechnology.sellmycar.user.repository.domain.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JwtService {

    private static final String SECRET_KEY = "5A7134743777217A25432A462D4A614E645267556B58703272357538782F413F";
    private final PersonRepository personRepository;

    public String extractUserName(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(final String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);

    }

    public String generateToken(final UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public boolean isTokenValid(final String token, final UserDetails userDetails) {
        final String userName = extractUserName(token);
        return userName.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    public UserDetails getActiveLogin(final String username) {
        final Person user = personRepository.findByLoginsEmailAndLoginsActiveTrue(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        final Login activeLogin = user.getLogins().stream()
            .filter(login -> login.isActive())
            .findFirst().orElseThrow(() -> new AccountExpiredException(String.format("No active login found for user %s", username)));

        var role = switch (user) {
            case Dealer dealer -> Role.DEALER;
            case Customer customer -> Role.CUSTOMER;
            case Admin admin -> Role.ADMIN;
            default -> throw new IllegalStateException("Unknown role for user: " + user);
        };

        return JwtUserDetails.builder()
            .email(activeLogin.getEmail())
            .password(activeLogin.getPassword())
            .active(activeLogin.isActive())
            .role(role)
            .build();
    }

    private boolean isTokenExpired(final String token)
    {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    public String generateToken(final Map<String, Object> extraClaims, final UserDetails userDetails) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSingingKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Claims extractAllClaims(final String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSingingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private Key getSingingKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
