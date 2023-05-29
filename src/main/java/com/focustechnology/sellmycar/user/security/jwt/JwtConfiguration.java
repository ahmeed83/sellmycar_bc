package com.focustechnology.sellmycar.user.security.jwt;

import com.focustechnology.sellmycar.user.repository.PersonRepository;
import com.focustechnology.sellmycar.user.repository.domain.Admin;
import com.focustechnology.sellmycar.user.repository.domain.Customer;
import com.focustechnology.sellmycar.user.repository.domain.Dealer;
import com.focustechnology.sellmycar.user.repository.domain.Login;
import com.focustechnology.sellmycar.user.repository.domain.Person;
import com.focustechnology.sellmycar.user.repository.domain.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class JwtConfiguration {
    private final PersonRepository personRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> getActiveLogin(username);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(final AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private UserDetails getActiveLogin(final String username) {
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
}
