package com.igym.igym.repository;

import com.igym.igym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByRegistrationNumber(String registrationNumber);

    Optional<Student> findByCpf(String cpf);

    void deleteByCpf(String cpf);
    @Transactional
    @Modifying
    @Query("UPDATE Student s " +
            "SET s.height = :height, " +
            "s.weight = :weight, " +
            "s.medications = :medications, " +
            "s.surgeries = :surgeries, " +
            "s.payment = :payment, " +
            "s.healthHistory = :healthHistory, " +
            "s.bloodPressure = :bloodPressure, " +
            "s.email = :email, " +
            "s.phoneNumber = :phoneNumber, " +
            "s.gender = :gender, " +
            "s.password = :password" +
            "WHERE s.cpf = :cpf OR s.registrationNumber = :registrationNumber")
    int updateByCpfOrRegistrationNumber(
            String cpf,
            String registrationNumber,
            Double height,
            Double weight,
            String medications,
            String surgeries,
            String payment,
            String healthHistory,
            String bloodPressure,
            String email,
            String phoneNumber,
            String gender,
            String password
    );

    @Query("SELECT s FROM Student s WHERE s.cpf = :cpf OR s.registrationNumber = :registrationNumber")
    Optional<Student> findByCpfOrRegistrationNumber(
            @Param("cpf") String cpf, @Param("registrationNumber") String registrationNumber
    );

    void delete(Optional<Student> deletedStudent);
}
