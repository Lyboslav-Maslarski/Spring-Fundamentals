package com.example.mobilelele.models.mapper;

import com.example.mobilelele.models.dto.user.UserRegisterDTO;
import com.example.mobilelele.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "active",constant = "true")
    User userDTOToUser(UserRegisterDTO userRegisterDTO);
}
