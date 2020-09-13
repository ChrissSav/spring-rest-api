package com.example.BaseApi.mapper;

import com.example.BaseApi.dto.UserResponse;
import com.example.BaseApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", source = "userId")
    UserResponse mapToUserResponse(User user);
}
