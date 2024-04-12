package com.example.backtms.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "patient")
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
