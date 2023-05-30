package com.focustechnology.sellmycar.user.controller;

import com.focustechnology.sellmycar.user.UserService;
import com.focustechnology.sellmycar.user.controller.json.AuthenticationResponse;
import com.focustechnology.sellmycar.user.controller.json.SigninRequest;
import com.focustechnology.sellmycar.user.controller.json.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/auth/signup/dealer")
    public ResponseEntity<AuthenticationResponse> signupDealer(
            final @RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.signupDealer(request));
    }

    @PostMapping("/auth/signup/customer")
    public ResponseEntity<AuthenticationResponse> signupCustomer(
            final @RequestBody SignupRequest request) {
        return ResponseEntity.ok(userService.signupCustomer(request));
    }

    @PostMapping("/auth/signin")
    public ResponseEntity<AuthenticationResponse> signin(
            final @RequestBody SigninRequest request) {
        return ResponseEntity.ok(userService.signinUser(request));
    }

}
