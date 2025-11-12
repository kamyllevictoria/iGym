package com.igym.igym.controller;

import com.igym.igym.controller.dto.StudentDTO;
import com.igym.igym.controller.mapper.StudentMapper;
import com.igym.igym.model.Student;
import com.igym.igym.repository.StudentRepository;
import com.igym.igym.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequestMapping("/api/students")
@RestController
public class StudentController implements GenericController {

    private StudentService studentService;
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;

    public StudentController(StudentService studentService, StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        Student savedStudent = studentService.createStudent(student); // AQUI! savedStudent precisa ter o ID

        if (savedStudent.getUser().getId() == null) {
            // Isso é um problema de persistência que precisa ser investigado no service/model
            throw new IllegalStateException("Student ID was not generated after saving.");
        }

        URI location = generateHeaderLocation(savedStudent.getUser().getId()); // O generateHeaderLocation precisa receber o ID

        return ResponseEntity.created(location).body(savedStudent);
    }


}
