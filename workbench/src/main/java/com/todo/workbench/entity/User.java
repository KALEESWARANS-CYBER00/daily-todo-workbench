package com.todo.workbench.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String mobile;

    @Column(nullable = false)
    private String passwordHash;

    @Column(nullable = false)
    private String level = "LOW"; // LOW, MEDIUM, HIGH
}
