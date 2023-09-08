package com.micro.faceHR.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Office extends BaseEntity {

    @Id
    @GeneratedValue(
            generator = "UUID"
    )
    private UUID id;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String town;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String postalAddress;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;


}
