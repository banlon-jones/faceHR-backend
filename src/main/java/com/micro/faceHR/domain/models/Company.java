package com.micro.faceHR.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Company extends BaseEntity{

    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String socialSecurityNumber;

    @Column
    private String NIU;

    @Column
    private String RCS;

    @OneToMany(mappedBy = "company")
    private List<Office> offices;

    @OneToMany(mappedBy = "company")
    private List<User> users;

    @OneToMany(mappedBy = "company")
    private List<Department> departments;

    @OneToMany(mappedBy = "company")
    private List<Category> categories;

}
