package com.igym.igym.repositories;

import com.igym.igym.model.Administrador;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministradorRepository extends JpaRepository<Administrador, Long> {
    Optional<Administrador> findByEmail(String email);
}
