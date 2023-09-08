package com.micro.faceHR.controllers;


import com.micro.faceHR.domain.models.Company;
import com.micro.faceHR.domain.services.CompanyService;
import com.micro.faceHR.dto.CreateCompanyRequest;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/protected/company")
public class CompanyControler {

    private final CompanyService companyService;

    public ResponseEntity<Company> createCompany(@RequestBody @Valid CreateCompanyRequest companyRequest, @PathVariable String userId) {
        return ResponseEntity.ok(companyService.createCompany(companyRequest, userId));
    }
}
