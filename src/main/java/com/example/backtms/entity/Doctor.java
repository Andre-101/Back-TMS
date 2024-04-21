package com.example.backtms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "adminID")
    private Admin admin;

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    public Doctor() {}

    public Doctor(String username, String password, Admin admin) {
        this.username = username;
        this.password = password;
        this.admin = admin;
    }
}
