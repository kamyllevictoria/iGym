package com.igym.igym.repositories;

import com.igym.igym.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    Optional<Aluno> findById(Long aLong);

    Optional<Aluno> findByMatricula (Long matricula);

    @Query("SELECT a FROM Aluno a WHERE a.usuario.cpf = :cpf")
    Optional<Aluno> findByCpf(@Param("cpf") String cpf);

    Optional<Aluno> findByUsuarioId(Long usuarioId);

    boolean existsByMatricula(Long matricula);


    List<Aluno> findByProfessorCref(String cref);

}
