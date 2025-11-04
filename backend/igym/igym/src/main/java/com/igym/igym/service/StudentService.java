package com.igym.igym.service;

import com.igym.igym.controller.dto.StudentDTO;
import com.igym.igym.controller.mapper.StudentMapper;
import com.igym.igym.model.Student;
import com.igym.igym.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentMapper studentMapper;
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper){
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    //criar aluno
    @Transactional
    public Student createStudent(StudentDTO studentDTO){
        Student student = studentMapper.toEntity(studentDTO);
        if(studentRepository.findByCpf(student.getCPF()).isPresent()){
            throw  new IllegalArgumentException("Cpf já cadastrado.");
        }
        if(studentRepository.findByRegistrationNumber(student.getRegistrationNumber()).isPresent()){
            throw new IllegalArgumentException("Matricula já existente");
        }

        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDTO(savedStudent);
    }


    //pesquisar todos os alunos
    @Transactional(readOnly = true)
    public List<StudentDTO> findAllStudent(){
        List<Student> students = studentRepository.findAll();
        return studentMapper.toDTO(students);
    }

    //pesquisar todos os dados de um aluno via matricula ou cpf
    @Transactional(readOnly = true)
    public Student findStudentDetails(String cpf, String registrationNumber){
        Student student = studentRepository.findByCpfOrRegistrationNumber(cpf, registrationNumber)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No student found with CPF '%s' or registration number '%s'. ", cpf, registrationNumber)));

        return studentMapper.toDTO(student);
    }


    //pesquisar por cpf ou numero de matricula
    @Transactional(readOnly = true)
    public Student findByCpfOrRegistrationNumber(String cpf, String registrationNumber) {
        if(cpf == null && registrationNumber == null){
            throw new IllegalArgumentException("You must provide either CPF or registration number to search.");
        }
        Student studentCpfOrRegistrationNumber = studentRepository.findByCpfOrRegistrationNumber(cpf, registrationNumber)
                .orElseThrow(()-> new EntityNotFoundException(String.format("No student found with CPF '%s' or registration number '%s'.", cpf, registrationNumber)));


        return studentMapper.toDTO((Student) null);
    }

    //atualizar por cpf ou numero de matricula
    @Transactional
    public void updateStudentByCpfOrRegistration(Student student){
        if(student.getRegistrationNumber() == null && student.getCPF() == null){
            throw new IllegalArgumentException("To update student's data, is necessary to provide the registration number or the cpf.");
        }

        int updatedStudent = studentRepository.updateByCpfOrRegistrationNumber(
                student.getCPF(),
                student.getRegistrationNumber(),
                student.getHeight(),
                student.getWeight(),
                student.getMedications(),
                student.getSurgeries(),
                String.valueOf(student.getPayment()),
                student.getHealthHistory(),
                student.getBloodPressure(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getGender(),
                student.getPassword()
        );
        if(updatedStudent == 0){
            throw new EntityNotFoundException("No student found with provided cpf or registration number.");
        }
    }

    //deletar por cpf ou numero de matricula
    @Transactional
    public void deleteStudent(String cpf, String registrationNumber){
        if(cpf == null && registrationNumber == null){
            throw new IllegalArgumentException("You must provide either cpf or registration number to delete a student.");
        }

        Optional<Student> deletedStudent = studentRepository.findByCpfOrRegistrationNumber(cpf, registrationNumber);
        if(deletedStudent.isEmpty()){
            throw new EntityNotFoundException(String.format("No student found with cpf '%s' or registration number '%s'. ", cpf, registrationNumber));
        }

        studentRepository.delete(deletedStudent);
    }
}

