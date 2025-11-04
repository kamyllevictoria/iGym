package com.igym.igym.controller.mapper;

import com.igym.igym.controller.dto.TeacherDTO;
import com.igym.igym.model.Teacher;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    Teacher toEntity (TeacherDTO teacherDTO);
    Teacher toDTO (Teacher teacher);
}
