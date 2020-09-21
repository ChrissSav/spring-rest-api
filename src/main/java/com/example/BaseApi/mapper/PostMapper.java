package com.example.BaseApi.mapper;

import com.example.BaseApi.dto.PostRequest;
import com.example.BaseApi.dto.PostResponse;
import com.example.BaseApi.model.Post;
import com.example.BaseApi.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;


@Mapper(componentModel = "spring")
public abstract class PostMapper {

    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "postName", source = "postRequest.postName")
    @Mapping(target = "description", source = "postRequest.description")
    @Mapping(target = "user", source = "user")
    public abstract Post map(PostRequest postRequest, User user);


    @Mapping(target = "id", source = "postId")
    @Mapping(target = "timestamp", expression = "java(getTimestamp(post))")
    public abstract PostResponse mapToDto(Post post);

    Long getTimestamp(Post post) {
        return Timestamp.from(post.getCreatedDate()).getTime() / 1000L;
    }
}