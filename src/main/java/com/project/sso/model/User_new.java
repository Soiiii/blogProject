package com.project.sso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User_new {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable=false, length=30)
    private String name;

    @Column(nullable=false, length=200)
    private String email;

    @Column(nullable=false, length=100)
    private String password;

    private int gender;

    @Column(nullable=false, length=20)
    private String country;

    private int status;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    @CreationTimestamp
    private Timestamp create_at;

}
