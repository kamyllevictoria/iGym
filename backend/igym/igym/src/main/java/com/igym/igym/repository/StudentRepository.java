package com.igym.igym.repository;


import com.igym.igym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findByRegistrationNumber(Long registrationNumber);

    @Query(value = "SELECT * FROM usuario s WHERE s.cpf = :cpf LIMIT 1", nativeQuery = true)
    Optional<Student> findByCpf(@Param("cpf") String cpf);

    Optional<Student> findByUser_CPF(String cpf);
}
