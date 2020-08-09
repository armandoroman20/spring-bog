package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.GreetingSvc;
import com.codeup.springblog.services.SillySvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceTestController {

    private GreetingSvc greetingSvc;
    private SillySvc sillySvc;
    private EmailService emailSvc;
    private PostRepository postsDao;

    public ServiceTestController(GreetingSvc greetingSvc, SillySvc sillySvc, EmailService emailSvc, PostRepository postsDao){
        this.greetingSvc = greetingSvc;
        this.sillySvc = sillySvc;
        this.emailSvc = emailSvc;
        this.postsDao = postsDao;
    }

    @GetMapping("/email")
    @ResponseBody
    public String sendEmail(){
         emailSvc.prepareAndSend(postsDao.getOne(1L), "First email!", "Testing");
         return "Check your mailtrap inbox!";
    }

    @GetMapping("/silly")
    @ResponseBody
    public int totalLength(){
        return sillySvc.totalPostCharacters();
    }


    @GetMapping("/morning/{name}")
    @ResponseBody
    public String morningGreeting(@PathVariable String name){
        return greetingSvc.goodMorning(name);
    }

    @GetMapping("/afternoon/{name}")
    @ResponseBody
    public String afternoonGreeting(@PathVariable String name){
        return greetingSvc.goodAfternoon(name);
    }

    @GetMapping("/evening/{name}")
    @ResponseBody
    public String eveningGreeting(@PathVariable String name){
        return greetingSvc.goodEvening(name);
    }

}
