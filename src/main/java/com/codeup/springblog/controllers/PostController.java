package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PostController {
//    private List<Post> post = new ArrayList<>();
    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;

    }

//    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    @GetMapping("/posts")
    public String viewPost(Model model){
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

//    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @GetMapping("/posts/{id}")
    public String postId(@PathVariable long id, Model model){
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @PostMapping("/posts/delete/{id}")
    public String deletePost(@RequestParam("deleteButton") Long id){
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit")
    public String editPost(@RequestParam("editButton") long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/editpost";
    }

    @PostMapping("/posts/edit/{id}")
    public String editPost(@RequestParam("postId") long id, @RequestParam("title") String title, @RequestParam("body") String body) {
        Post post = postDao.getById(id);
        post.setTitle(title);
        post.setBody(body);
        postDao.save(post);
        return "redirect:/posts/" + id;
    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @GetMapping("/posts/create")
    @ResponseBody
    public String createForm(){
        return "view the form for creating a post.";
    }

//    @RequestMapping(path = "/posts/create", method = RequestMethod.POST)
     @PostMapping("/posts/create")
    @ResponseBody
    public String postCreate(){
        return "create a new post.";
    }




}
