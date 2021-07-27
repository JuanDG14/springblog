package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.User;
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

    @GetMapping("/posts")
    public String postsIndex(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam("deleteButton") long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/edit")
    public String editForm(@RequestParam("editButton") long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/editpost";
    }

    @PostMapping("/posts/edit")
    public String editPost(@RequestParam("postId") long id, @RequestParam("title") String title, @RequestParam("body") String body) {
        Post editPost = postDao.getById(id);
        editPost.setTitle(title);
        editPost.setBody(body);
        postDao.save(editPost);
        return "redirect:/posts/" + id;
    }

    @GetMapping("/posts/{id}")
    public String getPostById(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.findById(id));
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String getCreatePost() {
        return "posts/createpost";
    }

    @PostMapping("/posts/create")
    public String postCreatePost(@RequestParam String title, @RequestParam String body) {
        User user = userDao.getById(1L);
        Post post = new Post(title, body, user);
        postDao.save(post);
        return "redirect:/posts";
    }
}
