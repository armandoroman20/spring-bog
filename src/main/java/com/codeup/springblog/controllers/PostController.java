package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Ad;
import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;
    private final EmailService emailSvc;


    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailSvc){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailSvc = emailSvc;
    }
    

    // still need to refactor method like I have them in the ADController
    @GetMapping("/posts")
//    public List<Post> getPosts () { return postsDao.findAll(); }
    public String index(Model model) {
        model.addAttribute("posts", postsDao.findAll());
        return "posts/index";
    }


    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        Post pullledPost = postsDao.getOne(id);
        model.addAttribute("post", pullledPost);
        User pullledUser = usersDao.getOne(id);
        model.addAttribute("user", pullledUser);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showPostForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post){
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = usersDao.getOne(1L);
        post.setAuthor(loggedInUser);
        postsDao.save(post);
        emailSvc.prepareAndSend(postsDao.getOne(1L), "Another Post!", "Post Created: You listed a new item for sale");
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model model) {
        // the below code will grab the id of the post the user wants to edit
        // and sent it to the view
        model.addAttribute("post", postsDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(@PathVariable long id, @ModelAttribute Post post){
        User user = usersDao.getOne(1L);
        post.setAuthor(user);
        postsDao.save(post);
        return "redirect:/posts";
    }


    @RequestMapping("/posts/{id}/delete")
    public String deleteForm(@PathVariable long id) {
        postsDao.deleteById(id);
        return "redirect:/posts";
    }



}
