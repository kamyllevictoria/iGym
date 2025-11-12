package com.igym.igym.controller.mapper;

import com.igym.igym.controller.dto.StudentDTO;
import com.igym.igym.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "userDTO.id", target = "user.id") // <-- AQUI ESTÁ A CHAVE
    @Mapping(source = "userDTO", target = "user") // Mapeia o objeto UserDTO inteiro para o User
    Student toEntity(StudentDTO studentDTO);

    // 2. Entidade para DTO
    // CORREÇÃO: Mapear 'user.id' da Entidade (origem) para 'userDTO.id' no DTO (destino)
    @Mapping(source = "user.id", target = "userDTO.id")
    @Mapping(source = "user", target = "userDTO") // Mapeia o objeto User inteiro para o UserDTO
    StudentDTO toDto(Student student);

    // 3. Mapeamento de Coleções (OK, se a entrada for List<Student>)
    List<StudentDTO> toDTO(List<Student> students);
}
