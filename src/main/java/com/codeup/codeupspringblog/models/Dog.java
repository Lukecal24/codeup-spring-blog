//package com.codeup.codeupspringblog.models;
//
//import jakarta.persistence.*;
//
//@Entity
//public class Dog {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(columnDefinition = "int(11) UNSIGNED", nullable = true, unique = true)
//    private long id;
//
//    @Column(length=3, nullable = false)
//    private int age;
//
//    @Column(length = 200, nullable = false)
//    private String name;
//
//    @Column(length = 2, nullable = false)
//    private String resideState;
//
//    public Dog(long id, int age, String name, String resideState) {
//        this.id = id;
//        this.age = age;
//        this.name = name;
//        this.resideState = resideState;
//    }
//
//    public Dog(){
//
//    }
////    Getters and Setters
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
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
//    public String getResideState() {
//        return resideState;
//    }
//
//    public void setResideState(String resideState) {
//        this.resideState = resideState;
//    }
//}
