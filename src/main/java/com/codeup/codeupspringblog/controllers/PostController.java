package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post("First Post", "This is the body of the first post."));
        posts.add(new Post("Second Post", "This is the body of the second post."));
        model.addAttribute("posts", posts);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Post post = new Post("Sample Title", "Sample Body");
        model.addAttribute("post", post);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String postCreate() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreatePost() {
        return "redirect:/posts";
    }
}
