package com.retsapis.blogging_application.repository;

import com.retsapis.blogging_application.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
