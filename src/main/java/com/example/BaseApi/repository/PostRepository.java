package com.example.BaseApi.repository;

import com.example.BaseApi.model.Post;
import com.example.BaseApi.model.Subreddit;
import com.example.BaseApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}
