package com.mahmutcelik.demo1.service.post;

import com.mahmutcelik.demo1.exception.LocationNotFoundException;
import com.mahmutcelik.demo1.exception.PostNotFoundException;
import com.mahmutcelik.demo1.exception.UserNotFoundException;
import com.mahmutcelik.demo1.model.Post;
import com.mahmutcelik.demo1.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAllPosts() throws PostNotFoundException {
        List<Post> tempList =  postRepository.findAll();
        if(tempList.size()>0) return tempList;
        throw new PostNotFoundException();
    }

    @Override
    public Post getPostById(Long id) throws PostNotFoundException {
        return postRepository.findById(id).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public Post addNewPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post post) throws PostNotFoundException {
        return postRepository.findById(id).map(e -> postRepository.save(post)).orElseThrow(PostNotFoundException::new);
    }

    @Override
    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}

