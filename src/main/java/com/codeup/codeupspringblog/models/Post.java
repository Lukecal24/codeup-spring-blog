package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "int(11) UNSIGNED", nullable = true, unique = true)
    private Long id;
    @Column(length = 200, nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;


    //Constructors
    public Post() {

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}
