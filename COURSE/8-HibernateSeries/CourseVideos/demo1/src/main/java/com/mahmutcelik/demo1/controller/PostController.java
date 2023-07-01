package com.mahmutcelik.demo1.controller;


import com.mahmutcelik.demo1.exception.PostNotFoundException;
import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.Post;
import com.mahmutcelik.demo1.service.post.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    private List<Post> getAllPosts() throws PostNotFoundException {
        return postService.getAllPosts();
    }

    @GetMapping("/post/{id}")
    private Post getPostById(@PathVariable Long id) throws PostNotFoundException {
        return postService.getPostById(id);
    }

    @PostMapping("/post")
    private Post addNewPost(@RequestBody Post post){
        return postService.addNewPost(post);
    }

    @PutMapping("/post/{id}")
    private Post updatePost(@PathVariable("id") Long id,@RequestBody Post post) throws PostNotFoundException {
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/post/{id}")
    private void deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
    }
}
