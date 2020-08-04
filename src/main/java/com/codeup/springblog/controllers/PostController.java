package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String index(Model model) {
        ArrayList<Post> myPosts = new ArrayList<>();
        myPosts.add(new Post(2, "title 2", "more randomness"));
        myPosts.add(new Post(3, "title 3", "I need to eat"));
        myPosts.add(new Post(4, "title 4", "need more protein"));

        model.addAttribute("posts", myPosts);
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post post1 = new Post(id,"Monday", "Need to do cardio for 15 minutes, " +
                "wearing hoodie");
        model.addAttribute("title", post1.getTitle());
        model.addAttribute("body", post1.getBody());
        return "posts/show";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPost(){

        return "Here is the form to create a post!";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String insertPost(){
        return "Post has been created!";
    }

}
