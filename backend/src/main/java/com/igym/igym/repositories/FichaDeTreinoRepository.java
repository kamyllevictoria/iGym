package com.igym.igym.repositories;

import com.igym.igym.model.FichaDeTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaDeTreinoRepository extends JpaRepository<FichaDeTreino, Long> {

    List<FichaDeTreino> findByAlunoMatricula(Long alunoMatricula);

    List<FichaDeTreino> alunoMatricula(Long alunoMatricula);
}
