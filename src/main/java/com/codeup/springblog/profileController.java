package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class profileController {

    @GetMapping("/profile/{username}")
//    @ResponseBody
    public String viewProfile(@PathVariable String username, Model model){
        model.addAttribute("user", username);
        return "profile";
    }

    @GetMapping("/profile")
    public String viewProfile(){
        return "profile";
    }

    @PostMapping("/profile")
    public String returnCohort(@RequestParam(name = "username") String username, @RequestParam(name="password") String myPassword, Model model){
        ArrayList<String> ads = new ArrayList<String>();
        boolean isLoggedIn = true;
        ads.add("Ad 1");
        ads.add("Ad 2");
        ads.add("Ad 3");

        model.addAttribute("username", username);
        model.addAttribute("password", myPassword);
        model.addAttribute("ads", ads);
        model.addAttribute("isLoggedIn", isLoggedIn);

        return "profile";
    }
}
