package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class MathController {

    @RequestMapping(path = "/add/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int addition(@PathVariable int number, @PathVariable int number2){
        return number + number2;
    }

    @RequestMapping(path = "/subtract/{number}/from/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int number, @PathVariable int number2){
        return number2 - number;
    }

    @RequestMapping(path = "/multiply/{number}/and/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int number, @PathVariable int number2){
        return number * number2;
    }

    @RequestMapping(path = "/divide/{number}/by/{number2}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int number, @PathVariable int number2){
        return number / number2;
    }
}
