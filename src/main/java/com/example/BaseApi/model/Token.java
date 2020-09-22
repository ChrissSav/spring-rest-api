package com.example.BaseApi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Token {
    @Id
    private String token;
    @JoinColumn(name = "user_id")
    @OneToOne
    private User user;
}
