package com.example.backtms.repository;

import com.example.backtms.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {

}