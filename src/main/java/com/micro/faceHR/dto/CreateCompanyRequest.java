package com.micro.faceHR.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCompanyRequest {

    @NotBlank
    private String Name;

    private String description;

    @NotBlank
    private String phone;

    @Email
    private String email;

    private String socialSecurityNumber;

    private String NIU;

    private String RCS;
}
