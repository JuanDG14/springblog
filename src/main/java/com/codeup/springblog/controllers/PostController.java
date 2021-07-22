package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private List<Post> post = new ArrayList<>();

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
//    @GetMapping("/posts")
    public String viewPost(Model model){
        post.add(new Post("This is post1", "This is podt1's body"));
        post.add(new Post("This is post2", "This is podt2's body"));
        model.addAttribute("post", post);
        return "posts/index";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
//    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model){
        Post post = new Post("Hello there", "im not sure what im doing");
        return "posts/show";
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
