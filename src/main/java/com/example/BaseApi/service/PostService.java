package com.example.BaseApi.service;


import com.example.BaseApi.dto.PostRequest;
import com.example.BaseApi.dto.PostResponse;
import com.example.BaseApi.exceptions.ApiException;
import com.example.BaseApi.exceptions.ExceptionCodes;
import com.example.BaseApi.mapper.PostMapper;
import com.example.BaseApi.model.Post;
import com.example.BaseApi.repository.PostRepository;
import com.example.BaseApi.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
@Transactional
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final AuthService authService;
    private final PostMapper postMapper;


    public void save(PostRequest postRequest) {
        postRepository.save(postMapper.map(postRequest, authService.getCurrentUser()));
    }


    public List<PostResponse> getAllPosts() {
        List<PostResponse> list = postRepository.findByUser(authService.getCurrentUser())
                .stream()
                .map(postMapper::mapToDto)
                .collect(Collectors.toList());
        return list;
    }

    public void delete(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new ApiException(ExceptionCodes.POST_NOT_FOUND));
        if (post.getUser() == authService.getCurrentUser()) {
            postRepository.deleteById(postId);
        } else {
            throw new ApiException(ExceptionCodes.POST_NOT_BELONG_TO_USER);
        }
        //postRepository.deleteByPostIdAndUser(postId, authService.getCurrentUser());
    }
}























