package com.example.backtms.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private long age;
    private String gender;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    @JsonManagedReference
    @OneToMany(mappedBy = "patient")
    private List<Measurement> measurements;

    public Patient() {}

    public Patient(String name, long age, String gender, Doctor doctor) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.doctor = doctor;
    }
}
