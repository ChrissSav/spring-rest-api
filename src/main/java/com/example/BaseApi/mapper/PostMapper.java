package com.example.BaseApi.mapper;

import com.example.BaseApi.dto.PostRequest;
import com.example.BaseApi.model.Post;
import com.example.BaseApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "postName", source = "postRequest.postName")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, User user);

}