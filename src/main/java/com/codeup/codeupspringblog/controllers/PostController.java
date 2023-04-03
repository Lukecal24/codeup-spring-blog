package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.Services.EmailService;
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

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository usersDao, EmailService emailService) {
        this.postDao = postDao;
        this.usersDao = usersDao;
        this.emailService = emailService;
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
    @PostMapping("/posts/create")
    public String postCreatePost(@ModelAttribute Post post) {
        User user = usersDao.findById(1); // Change this to get the current user
        post.setUser(user);
        postDao.save(post);

        // Prepare and send email to the post's user
        String subject = "New post created";
        String body = "Your post has been created with title: " + post.getTitle();
        emailService.prepareAndSend(post, subject, body);

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
