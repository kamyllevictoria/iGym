package com.igym.igym.services;

import com.igym.igym.dtos.ExercicioFichaRequestDTO;
import com.igym.igym.dtos.FichaDeTreinoRequestDTO;
import com.igym.igym.model.Aluno;
import com.igym.igym.model.ExercicioFicha;
import com.igym.igym.model.FichaDeTreino;
import com.igym.igym.model.Professor;
import com.igym.igym.repositories.AlunoRepository;
import com.igym.igym.repositories.FichaDeTreinoRepository;
import com.igym.igym.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FichaDeTreinoService {

    @Autowired
    private FichaDeTreinoRepository fichaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    private List<ExercicioFicha> toExercicioFichaList(List<ExercicioFichaRequestDTO> dtos) {
        return dtos.stream().map(dto -> new ExercicioFicha(
                dto.getNome(),
                dto.getAgrupamentoMuscular(),
                dto.getSeries(),
                dto.getRepeticoes(),
                dto.getTempoDescanso()
        )).collect(Collectors.toList());
    }

    public FichaDeTreino criarFicha(FichaDeTreinoRequestDTO dto) {

        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com ID: " + dto.getAlunoId()));
        String cref = dto.getProfessorCref();
        Professor professor = professorRepository.findByCref(cref)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com CREF: " + cref));

        List<ExercicioFicha> exercicios = toExercicioFichaList(dto.getListaDeExercicios());
        FichaDeTreino ficha = new FichaDeTreino();

        ficha.setFrequenciaSemanal(dto.getFrequenciaSemanal());
        ficha.setListaDeExercicios(exercicios);

        ficha.setAluno(aluno);
        ficha.setProfessor(professor);

        return fichaRepository.save(ficha);
    }

    public List<FichaDeTreino> findAll() {
        return fichaRepository.findAll();
    }
}