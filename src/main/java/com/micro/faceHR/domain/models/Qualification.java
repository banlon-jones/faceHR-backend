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
public class Qualification  extends BaseEntity{

    @Id
    @GeneratedValue( generator = "uuid")
    private UUID uuid;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String attachmentUrl;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
