package com.micro.faceHR.domain.services;

import com.micro.faceHR.domain.models.Company;
import com.micro.faceHR.domain.repositories.CompanyRepository;
import com.micro.faceHR.dto.CreateCompanyRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    private final UserService userService;

    public Company createCompany(CreateCompanyRequest companyDetails, String userId) {

        Company company = Company.builder()
                .name(companyDetails.getName())
                .email(companyDetails.getEmail())
                .description(companyDetails.getDescription())
                .phone(companyDetails.getPhone())
                .socialSecurityNumber(companyDetails.getSocialSecurityNumber())
                .NIU(companyDetails.getNIU())
                .RCS(companyDetails.getRCS())
                .build();
        company = companyRepository.save(company);
        userService.addUserToCompany(UUID.fromString(userId), company.getId());
        return company;
    }
}
