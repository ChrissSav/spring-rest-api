package com.example.BaseApi.repository;

import com.example.BaseApi.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional
public interface SessionRepository extends JpaRepository<Session, String> {
    Optional<Session> findBySession(String session);
}
