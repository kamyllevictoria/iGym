package com.igym.igym.controller.mapper;

import com.igym.igym.controller.dto.UserDTO;
import com.igym.igym.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity (UserDTO userDTO);
    User toDTO (User user);
}
