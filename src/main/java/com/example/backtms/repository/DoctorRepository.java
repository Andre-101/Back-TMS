package com.example.backtms.repository;

import com.example.backtms.entity.Admin;
import com.example.backtms.entity.Doctor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    @Query("SELECT u FROM Doctor u WHERE u.email = :email")
    public Optional<Doctor> searchByEmail(@Param("email") String email);

    @Query("SELECT u FROM Doctor u WHERE u.email = :email AND u.password = :password")
    public Optional<Doctor> getDoctorByEmailAndPassword(
            @Param("email") String email,
            @Param("password") String password
    );

    @Query("SELECT u FROM Doctor u WHERE u.username = :username")
    public Optional<Doctor> searchByUsername(@Param("username") String username);

    @Query("SELECT u FROM Doctor u WHERE u.username = :username AND u.password = :password")
    public Optional<Doctor> getDoctorByUsernameAndPassword(
            @Param("username") String username,
            @Param("password") String password
    );

    @Query("SELECT u FROM Admin u WHERE u.email = :email AND u.password = :password")
    public Optional<Admin> getAdminByEmailAndPassword(
            @Param("email") String email,
            @Param("password") String password
    );
}
