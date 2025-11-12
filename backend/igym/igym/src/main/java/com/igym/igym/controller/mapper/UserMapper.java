package com.igym.igym.controller.mapper;

import com.igym.igym.controller.dto.UserDTO;
import com.igym.igym.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    static User toEntity(UserDTO userDTO) {
        return null;
    }

    User toDTO (User user);
}
