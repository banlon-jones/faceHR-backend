package com.micro.faceHR.domain.repositories;

import com.micro.faceHR.domain.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CompanyRepository extends JpaRepository<Company, UUID> {
}
