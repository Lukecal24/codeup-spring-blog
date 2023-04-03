package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
public class PostController {
    private final PostRepository postDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postDao, UserRepository usersDao) {
        this.postDao = postDao;
        this.usersDao = usersDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    //create
    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreate(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

//    @PostMapping("/posts/create")
//    public String postCreatePost(@RequestParam (name="title")String title, @RequestParam(name="body")String body) {
//        User user = usersDao.findById(1);
//        Post newPost = new Post(title, body);
//        postDao.save(newPost);
//        return "redirect:/posts";
//    }
    @PostMapping("/posts/create")
    public String postCreatePost(@ModelAttribute Post post) {
        User user = usersDao.findById(1);
        post.setUser(user);
        postDao.save(post);
        return "redirect:/posts";
    }

    //edit
    @GetMapping("/posts/{id}/edit")
    public String postEditForm(@PathVariable long id, Model model) {
        Post post = postDao.findById(id);
        model.addAttribute("post", post);
        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String postEdit(@PathVariable long id, @ModelAttribute Post updatedPost) {
        Post post = postDao.findById(id);
        post.setTitle(updatedPost.getTitle());
        post.setBody(updatedPost.getBody());
        postDao.save(post);
        return "redirect:/posts";
    }
}
