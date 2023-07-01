package com.mahmutcelik.onetomany_unidirectional;

import com.mahmutcelik.onetomany_unidirectional.model.Post;
import com.mahmutcelik.onetomany_unidirectional.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class Controller {
    private final PostRepository postRepository;

    public Controller(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @PostMapping
    private void add(@RequestBody Post post){
        postRepository.save(post);
    }


}
