package com.micro.faceHR.dto;

import com.micro.faceHR.constants.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeInfo {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    private Gender gender;

    private Date startDate;

    private Status status;

    private String nationality;

    private String jobTitle;

    private String IDN;

    private String dateOfBirth;

    private MaritalStatus maritalStatus;

    private ContractType contractType;

    private String socialSecurityNumber;

    private String taxPayerNumber;

}
