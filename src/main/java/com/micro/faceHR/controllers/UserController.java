package com.micro.faceHR.controllers;

import com.micro.faceHR.domain.services.AuthenticationService;
import com.micro.faceHR.dto.AuthenticationResponse;
import com.micro.faceHR.dto.LoginRequest;
import com.micro.faceHR.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/public/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        return null;
    }

}
