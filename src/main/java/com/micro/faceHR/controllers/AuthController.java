package com.micro.faceHR.controllers;

import com.micro.faceHR.domain.models.User;
import com.micro.faceHR.domain.services.AuthenticationService;
import com.micro.faceHR.dto.AuthenticationResponse;
import com.micro.faceHR.dto.EmployeeInfo;
import com.micro.faceHR.dto.LoginRequest;
import com.micro.faceHR.dto.RegisterRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @PostMapping("/register/{companyId}")
    public ResponseEntity<AuthenticationResponse> registerUser(@RequestBody @Valid RegisterRequest registerRequest, @PathVariable String companyId) {
        return ResponseEntity.ok(authenticationService.register(registerRequest, companyId));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.authenticate(loginRequest));
    }

}
