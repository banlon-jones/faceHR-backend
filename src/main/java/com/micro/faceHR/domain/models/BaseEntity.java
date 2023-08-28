package com.micro.faceHR.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

public class BaseEntity {

    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt;

    @Column(nullable = false)
    protected LocalDateTime updatedAt;

    @PrePersist
    public void atCreate() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void atUpdate() { this.updatedAt = LocalDateTime.now(); }
}
