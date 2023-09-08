package com.micro.faceHR.domain.repositories;

import com.micro.faceHR.domain.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QualificationRepository extends JpaRepository<Qualification, UUID> {
}
