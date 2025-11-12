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
    public ResponseEntity<Void> save(@RequestBody @Valid StudentDTO studentDTO){
        Student studentEntity = studentMapper.toEntity(studentDTO);

        studentService.createStudent(studentEntity);
        URI location = generateHeaderLocation(studentEntity.getRegistrationNumber());

        List<StudentDTO> studentResponseDTO = studentMapper.toDTO((List<Student>) studentEntity);
        return ResponseEntity.created(location).build();
    }


}
