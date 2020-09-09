package com.example.BaseApi.repository;

import com.example.BaseApi.model.Comment;
import com.example.BaseApi.model.Post;
import com.example.BaseApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}
