package com.example.backtms.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "measurement")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "report")
    private Report report;

    public Measurement() {}
}
