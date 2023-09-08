package com.micro.faceHR.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Department extends BaseEntity{

    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    private UUID id;

    private String name;

    private String description;

    @OneToMany(mappedBy = "department")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
}
