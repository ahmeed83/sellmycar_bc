package com.focustechnology.sellmycar.user;

import com.focustechnology.sellmycar.user.controller.json.AuthenticationResponse;
import com.focustechnology.sellmycar.user.controller.json.SigninRequest;
import com.focustechnology.sellmycar.user.controller.json.SignupRequest;
import com.focustechnology.sellmycar.user.repository.DealerRepository;
import com.focustechnology.sellmycar.user.repository.domain.Customer;
import com.focustechnology.sellmycar.user.repository.CustomerRepository;
import com.focustechnology.sellmycar.user.repository.domain.Dealer;
import com.focustechnology.sellmycar.user.repository.domain.Login;
import com.focustechnology.sellmycar.user.repository.domain.Role;
import com.focustechnology.sellmycar.user.security.jwt.JwtService;
import com.focustechnology.sellmycar.user.security.jwt.JwtUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DealerRepository dealerRepository;
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse signupDealer(final SignupRequest request) {
        var newLogin = createLogin(request);
        var dealer = Dealer.builder()
            .firstName(request.getFirstname())
            .lastName(request.getLastname())
            .address(request.getAddress())
            .logins(List.of(newLogin))
            .build();

        dealerRepository.save(dealer);
        var jwtUserDetails = JwtUserDetails.builder()
            .email(newLogin.getEmail())
            .password(newLogin.getPassword())
            .active(true)
            .role(Role.DEALER)
            .build();
        var jwtToken = jwtService.generateToken(jwtUserDetails);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }

    public AuthenticationResponse signupCustomer(final SignupRequest request) {
        var newLogin = createLogin(request);
        var customer = Customer.builder()
            .firstName(request.getFirstname())
            .lastName(request.getLastname())
            .address(request.getAddress())
            .logins(List.of(newLogin))
            .build();

        customerRepository.save(customer);
        var jwtUserDetails = JwtUserDetails.builder()
            .email(newLogin.getEmail())
            .password(newLogin.getPassword())
            .active(true)
            .role(Role.CUSTOMER)
            .build();
        var jwtToken = jwtService.generateToken(jwtUserDetails);
        return AuthenticationResponse.builder()
            .token(jwtToken)
            .build();
    }



    public AuthenticationResponse signinUser(final SigninRequest request) {
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
            )
        );
        return null;
    }

    private Login createLogin(final SignupRequest request) {
        return Login.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .active(true)
            .build();
    }

}
