package com.example.backtms.controllers;

import com.example.backtms.entity.Doctor;
import com.example.backtms.repository.AdminRepository;
import com.example.backtms.util.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)

public class APController {

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("doctor/create")
    public ResponseEntity<?> create(@RequestBody Doctor doctor) {
        adminRepository.save();
        return ResponseEntity.status(200).body(new GenericMessage("Usuario almacenado exitosamente"));
    }


}
