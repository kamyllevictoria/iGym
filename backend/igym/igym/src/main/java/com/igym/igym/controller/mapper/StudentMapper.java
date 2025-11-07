package com.igym.igym.controller.mapper;

import com.igym.igym.controller.dto.StudentDTO;
import com.igym.igym.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    Student toEntity(StudentDTO studentDTO);

    StudentDTO toDTO(Student student);

    List<StudentDTO> toDTO(List<Student> students);
}
