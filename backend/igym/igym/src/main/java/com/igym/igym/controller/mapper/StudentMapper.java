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
    @Mappings({
            @Mapping(source = "userDTO.id", target = "id"),
            @Mapping(source = "userDTO.name", target = "name"),
            @Mapping(source = "userDTO.email", target = "email"),
            @Mapping(source = "userDTO.password", target = "password"),
            @Mapping(source = "userDTO.phoneNumber", target = "phoneNumber"),
            @Mapping(source = "userDTO.gender", target = "gender"),
            @Mapping(source = "userDTO.birthDate", target = "birthDate"),
            @Mapping(source = "userDTO.CPF", target = "CPF"),
            @Mapping(source = "userDTO.age", target = "age")
    })
    Student toEntity(StudentDTO studentDTO);

    @Mappings({
            // Mapeia os campos da Entidade para a parte UserDTO do StudentDTO
            @Mapping(source = "id", target = "userDTO.id"),
            @Mapping(source = "name", target = "userDTO.name"),
            @Mapping(source = "email", target = "userDTO.email"),
            @Mapping(source = "password", target = "userDTO.password"),
            @Mapping(source = "phoneNumber", target = "userDTO.phoneNumber"),
            @Mapping(source = "gender", target = "userDTO.gender"),
            @Mapping(source = "birthDate", target = "userDTO.birthDate"),
            @Mapping(source = "CPF", target = "userDTO.CPF"),
            @Mapping(source = "age", target = "userDTO.age")
    })
    //quando transformamos algo para dto, usamos uma entidade no parametro
    Student toDTO(Student student);

    List<StudentDTO> toDTO(List<Student> students);

    List<StudentDTO> toDTO(Optional<Student> students);
}
