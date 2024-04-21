package com.example.backtms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "report")
    private Report report;

    public Measurement() {}
}
