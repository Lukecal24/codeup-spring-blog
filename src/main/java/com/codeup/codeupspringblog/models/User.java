package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> posts;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
