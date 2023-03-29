package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;


@Controller
public class PostController {
    private final PostRepository postDao;

    public PostController(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isPresent()){
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);
            return "posts/show";
        } else
            return "redirect:/posts";
    }

    @GetMapping("/posts/create")
    public String postCreate() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String postCreatePost(@RequestParam (name="title")String title, @RequestParam(name="body")String body) {
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "redirect:/posts";
    }
}
