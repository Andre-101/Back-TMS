package com.example.backtms.controllers;


import com.example.backtms.entity.Admin;
import com.example.backtms.entity.Doctor;
import com.example.backtms.repository.AdminRepository;
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
    @Autowired
    AdminRepository adminRepository;

    @PostMapping("user/create")
    public ResponseEntity<?> create(@RequestBody Doctor doctor) {
        doctorRepository.save(doctor);
        return ResponseEntity.status(200).body(new GenericMessage("Usuario almacenado exitosamente"));
    }

    @PostMapping("user/createAdmin")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        adminRepository.save(admin);
        return ResponseEntity.status(200).body(new GenericMessage("Admin almacenado exitosamente"));
    }

    @PostMapping("loginAdmin")
    public ResponseEntity<?> login(@RequestBody Admin admin){
        var result = doctorRepository.getAdminByEmailAndPassword(
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

    /* BUSQUEDA DE PACIENTES POR ID

    @GetMapping("user/search/{id}") //user/search/10
    public ResponseEntity<?> findById(@PathVariable("id") long id){
        var user = userRepository.findById(id);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user.get());
        }else{
            return ResponseEntity.status(400).body(
                    new GenericMessage("Usuario no encontrado")
            );
        }
    }

    //BUSQUEDA DE PACIENTES POR EMAIL
    @GetMapping("user/searchByEmail/{email}") //user/searchByEmail/alfa@a.com
    public ResponseEntity<?> searchByEmail(@PathVariable("email") String email){

        var user = userRepository.searchByEmail(email);
        if(user.isPresent()){
            return ResponseEntity.status(200).body(user.get());
        }else{
            return ResponseEntity.status(400).body(new GenericMessage("Usuario no encontrado"));
        }

    }

    //ELIMINACION DE PACIENTES POR ID
    @DeleteMapping("user/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") long id){
        userRepository.deleteById(id);
        return ResponseEntity.status(200).body(
                new GenericMessage("Usuario Eliminado")
        );
    }
    */

    //Endpoint para recibir la informacion del sensor
    @PostMapping("sensor")
    public ResponseEntity<?> sendData(@RequestBody Test test){
        var output = ResponseEntity.status(200).body(test);
        return output;
    }

}
