package com.example.BaseApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    private String session;
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
}
