package com.micro.faceHR.domain.repositories;

import com.micro.faceHR.domain.models.Office;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OfficeRepository extends JpaRepository<Office, UUID> {
}
