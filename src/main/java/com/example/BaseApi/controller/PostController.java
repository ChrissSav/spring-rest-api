package com.example.BaseApi.controller;

import com.example.BaseApi.dto.PostRequest;
import com.example.BaseApi.dto.PostResponse;
import com.example.BaseApi.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/posts")
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<String> createPost(@Valid @RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Post created!!");
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> userPosts = postService.getAllPosts();
        return ResponseEntity.status(HttpStatus.OK).body(userPosts);
    }


    @DeleteMapping(path = "/{postId}")
    public ResponseEntity<String> deletePost(@Valid @PathVariable(required = true) Long postId) {
        postService.delete(postId);
        return ResponseEntity.status(HttpStatus.OK).body("Delete successfully!!");
    }
}











