package com.micro.faceHR.dto;

import com.micro.faceHR.constants.Gender;
import com.micro.faceHR.constants.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String token;
}
