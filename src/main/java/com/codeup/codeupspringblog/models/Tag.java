//package com.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "tags")
//public class Tag {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false, unique = true)
//    private String name;
//
//    @ManyToMany(mappedBy = "tags")
//    private List<Post> posts;
//
//    // Constructors
//    public Tag() {}
//
//    public Tag(String name) {
//        this.name = name;
//    }
//
//    public Tag(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public List<Post> getPosts() {
//        return posts;
//    }
//
//    public void setPosts(List<Post> posts) {
//        this.posts = posts;
//    }
//}
