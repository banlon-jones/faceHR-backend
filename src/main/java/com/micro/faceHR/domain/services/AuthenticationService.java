package com.micro.faceHR.domain.services;

import com.micro.faceHR.constants.Role;
import com.micro.faceHR.constants.Status;
import com.micro.faceHR.domain.models.User;
import com.micro.faceHR.domain.repositories.UserRepository;
import com.micro.faceHR.dto.AuthenticationResponse;
import com.micro.faceHR.dto.LoginRequest;
import com.micro.faceHR.dto.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserService userService;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .role(Role.USER)
                .status(Status.ACTIVE)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse register(RegisterRequest registerRequest, String companyId) {
        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .status(Status.ACTIVE)
                .role(Role.USER)
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        User savedUser = userRepository.save(user);
        // Todo add user to company
        userService.addUserToCompany(user.getId(), UUID.fromString(companyId));

        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .id(savedUser.getId())
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .role(savedUser.getRole())
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate (LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new UsernameNotFoundException("User not found")
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .role(user.getRole())
                .token(jwtToken)
                .build();

    }
}
