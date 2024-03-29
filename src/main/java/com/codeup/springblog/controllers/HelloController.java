package com.codeup.springblog.controllers;

import com.codeup.springblog.services.EmailServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    private final EmailServices emailSvc;

    public HelloController(EmailServices emailSvc){
        this.emailSvc = emailSvc;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<h1>Hello From Spring!</h1>";
    }

    @GetMapping("/hello/{name}")

    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm(){
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model){
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
//        emailSvc.prepareAndSend("test@test.com", "Hello Welcome to " + cohort + "!", "Thank you for coming to our program");
        return "join";
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

