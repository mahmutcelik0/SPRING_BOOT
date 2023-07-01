package com.mahmutcelik.onetomany_unidirectional.repository;

import com.mahmutcelik.onetomany_unidirectional.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
