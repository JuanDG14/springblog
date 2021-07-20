package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello From Spring!</h1>";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "<h1>Hello im " + name + " nice to meet you!!</h1>";
    }

    @GetMapping("/number/{num}")
    @ResponseBody
    public int displayNumber(@PathVariable int num) {
        return num;
    }

    //    @GetMapping("/hello/in/{color}")
    @RequestMapping(path = "/hello/in/{color}", method = RequestMethod.GET)
    @ResponseBody
    public String helloInColor(@PathVariable String color) {
        return "<h1 style=\"color: " + color + "\">Hello in " + color + "!</h1>";
    }
}

