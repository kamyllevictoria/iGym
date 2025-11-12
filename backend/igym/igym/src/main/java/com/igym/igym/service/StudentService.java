package com.igym.igym.service;

import com.igym.igym.controller.mapper.StudentMapper;
import com.igym.igym.model.Student;
import com.igym.igym.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Random;

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
    public Student createStudent(Student student) {
        String cpf = student.getUser().getCPF();
        Optional<Student> existingStudent = studentRepository.findByUser_CPF(cpf);

        if (existingStudent.isPresent()) {
            throw new IllegalArgumentException("Erro: O CPF " + cpf + " já está cadastrado no sistema.");
        }
        return studentRepository.save(student);
    }

    private Object generateRandomRegistration() {
        String registration;
        do{
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 10; i++) {
                sb.append(random.nextInt(10));
            }
            registration = sb.toString();
        } while(studentRepository.findByRegistrationNumber(Long.valueOf(registration)).isPresent());
        return registration;
    }

}

