package com.mahmutcelik.demo1.service.post;

import com.mahmutcelik.demo1.exception.PostNotFoundException;
import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAllPosts() throws PostNotFoundException;

    Post getPostById(Long id) throws PostNotFoundException;

    Post addNewPost(Post post);

    Post updatePost(Long id, Post post) throws PostNotFoundException;

    void deletePost(Long id);
}
