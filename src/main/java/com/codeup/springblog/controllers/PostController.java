package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @GetMapping("/posts")
    @ResponseBody
    public String viewPost(){
        return "post index page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postId(@PathVariable long id){
        return "view individual post.";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
//    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "view the form for creating a post.";
    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
    // @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "create a new post.";
    }


}
