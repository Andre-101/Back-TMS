package com.example.backtms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "admin")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String username;
    private String password;

    @OneToMany(mappedBy = "admin")
    private List<Doctor> doctors;

    public Admin() {}

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
