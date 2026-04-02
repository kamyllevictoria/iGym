package com.igym.igym.repositories;

import com.igym.igym.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

    Optional<Professor> findByCref(String cref);

    String cref(String cref);
}
