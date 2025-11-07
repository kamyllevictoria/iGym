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

@RequestMapping
@RestController
public class StudentController {

    private StudentService studentService;
    private StudentRepository studentRepository;
    private StudentMapper studentMapper;
    private GenericController genericController;

    public StudentController(StudentService studentService, StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid StudentDTO studentDTO){
        Student studentEntity = studentMapper.toEntity(studentDTO);

        studentService.saveStudent(studentEntity);
        URI location = genericController.generateHeaderLocation(studentEntity.());

        StudentDTO studentResponseDTO = studentMapper.toDTO(studentEntity);
        return ResponseEntity.created(location).build();
    }


}
