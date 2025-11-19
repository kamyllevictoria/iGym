package com.igym.igym.repositories;

import com.igym.igym.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    Optional<Aluno> findById(Long aLong);

    Optional<Aluno> findByMatricula (Long matricula);

    Optional<Aluno> findByCpf(String cpf);


}
