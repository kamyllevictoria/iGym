package com.igym.igym.repositories;

import com.igym.igym.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    Optional<Usuario> findByNomeAndCpf(String nome, String cpf);

    Optional<Usuario> findByCpf(String cpf);
}
