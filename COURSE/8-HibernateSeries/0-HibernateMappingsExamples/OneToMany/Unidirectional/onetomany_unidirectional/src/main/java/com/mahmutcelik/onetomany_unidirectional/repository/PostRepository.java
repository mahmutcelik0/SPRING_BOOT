package com.mahmutcelik.onetomany_unidirectional.repository;

import com.mahmutcelik.onetomany_unidirectional.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
