package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController  {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }

    @GetMapping("/goodbye/{name}")
    @ResponseBody public String sayGoodbye(@PathVariable String name){
        return "Goodbye " + name;
    }

    @GetMapping("/books/{id}")
    @ResponseBody public String getBook(@PathVariable long id){
        return "Viewing book " + id;
    }

    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }
}
