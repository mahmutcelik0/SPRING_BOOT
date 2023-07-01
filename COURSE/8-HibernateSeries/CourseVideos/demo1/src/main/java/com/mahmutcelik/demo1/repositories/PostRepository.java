package com.mahmutcelik.demo1.repositories;

import com.mahmutcelik.demo1.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
