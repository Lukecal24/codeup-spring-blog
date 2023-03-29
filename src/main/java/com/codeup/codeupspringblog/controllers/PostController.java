package com.codeup.codeupspringblog.controllers;

import com.codeup.codeupspringblog.models.Post;
import com.codeup.codeupspringblog.models.User;
import com.codeup.codeupspringblog.repositories.PostRepository;
import com.codeup.codeupspringblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model) {
        Optional<Post> optionalPost = postDao.findById(id);
        if(optionalPost.isPresent()){
            Post post = postDao.findById(id).get();
            User user = post.getUser();
            String email = user.getEmail();
            model.addAttribute("email", email);
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
        User user = usersDao.findById(1);
        Post newPost = new Post(title, body);
        postDao.save(newPost);
        return "redirect:/posts";
    }
}
