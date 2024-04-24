package com.example.backtms.controllers;


import com.example.backtms.entity.Doctor;
import com.example.backtms.repository.DoctorRepository;
import com.example.backtms.util.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)

public class APController {

    @Autowired
    DoctorRepository doctorRepository;

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
        return ResponseEntity.status(200).body(new GenericMessage("Usuario almacenado exitosamente"));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Doctor doctor) {

        String email = doctor.getEmail();
        String password = doctor.getPassword();

        // Comparando con las credenciales correctas
        if ("Andy@hotmail.com".equals(email) && "1234".equals(password)) {
            return ResponseEntity.ok(new GenericMessage("Inicio de sesión exitoso"));
        } else {
            return ResponseEntity.status(401).body(new GenericMessage("Credenciales incorrectas"));
        }
    }


    @GetMapping("user/list")
    public ResponseEntity<?> list() {
        var users = doctorRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

}
