package com.example.backtms.controllers;


import com.example.backtms.entity.Admin;
import com.example.backtms.entity.Doctor;
import com.example.backtms.entity.Patient;
import com.example.backtms.repository.AdminRepository;
import com.example.backtms.repository.DoctorRepository;
import com.example.backtms.util.GenericMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(maxAge = 3600)
public class APController {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    AdminRepository adminRepository;

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
        return ResponseEntity.status(200).body(new GenericMessage("Usuario almacenado exitosamente"));
    }

    @PostMapping("patient/create/{id}")
    @Transactional
    public ResponseEntity<?> createPatient(@PathVariable("id") long id, @RequestBody Patient patient) {
        var user = doctorRepository.findById(id);

        if (user.isPresent()) {
            user.get().getPatients().add(patient);
            doctorRepository.save(user.get());
        }

        return ResponseEntity.status(200).body(new GenericMessage("Paciente almacenado exitosamente"));
    }

    @PostMapping("user/createAdmin")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return ResponseEntity.status(200).body(new GenericMessage("Admin almacenado exitosamente"));
    }

    @PostMapping("loginAdmin")
    public ResponseEntity<?> login(@RequestBody Admin admin){
        var result = adminRepository.getAdminByEmailAndPassword(
                admin.getEmail(),
                admin.getPassword()
        );
        return result.isPresent() ?
                ResponseEntity.status(200).body(result.get()) :
                ResponseEntity.status(403).body(new GenericMessage("NO ERES UN ADMIN"));
    }


    @PostMapping("loginDoctor")
    public ResponseEntity<?> login(@RequestBody Doctor doctor){
        var result = doctorRepository.getDoctorByEmailAndPassword(
                doctor.getEmail(),
                doctor.getPassword()
        );
        return result.isPresent() ?
                ResponseEntity.status(200).body(result.get()) :
                ResponseEntity.status(403).body(new GenericMessage("NO ERES UN DOCTOR"));
    }


    @GetMapping("user/list")
    public ResponseEntity<?> list() {
        var users = doctorRepository.findAll();
        return ResponseEntity.status(200).body(users);
    }

    @GetMapping("admin/list")
    public ResponseEntity<?> listDoctors() {
        return ResponseEntity.status(200).body(doctorRepository.findAll());
    }

    @GetMapping("doctor/list/{id}")
    public ResponseEntity<?> listPatient(@PathVariable Long id) {
        var result = doctorRepository.findById(id);
        return result.isPresent() ?
                ResponseEntity.status(200).body(result.get().getPatients()) :
                ResponseEntity.status(403).body(new GenericMessage("NO ERES UN DOCTOR"));
    }

    @DeleteMapping("patient/delete/{idDoctor}/{idPatient}")
    public ResponseEntity<?> deletePatient(@PathVariable("idDoctor") long idDoctor, @PathVariable("idPatient") long idPatient) {
        var user = doctorRepository.findById(idDoctor);
        if (user.isPresent()) {
            user.get().getPatients().removeIf(patient -> patient.getId() == idPatient);
            doctorRepository.save(user.get());
        }
        return ResponseEntity.status(200).body(
                new GenericMessage("Usuario Eliminado")
        );
    }

    @DeleteMapping("doctor/delete/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") long id){
        doctorRepository.deleteById(id);
        return ResponseEntity.status(200).body(
                new GenericMessage("Usuario Eliminado")
        );
    }
}
