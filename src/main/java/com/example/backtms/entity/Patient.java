package com.example.backtms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private long age;
    private String gender;

    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    @OneToMany(mappedBy = "patient")
    private List<Report> reports;

    public Patient() {}

    public Patient(String name, long age, String gender, Doctor doctor) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.doctor = doctor;
    }
}
