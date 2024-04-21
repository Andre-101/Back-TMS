package com.example.backtms.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long date;
    private String note;

    @ManyToOne
    @JoinColumn(name = "patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;

    @OneToMany(mappedBy = "report")
    private List<Measurement> measurements;

    public Report() {}

    public Report(long date, String note, Patient patient) {
        this.date = date;
        this.note = note;
        this.patient = patient;
    }
}
