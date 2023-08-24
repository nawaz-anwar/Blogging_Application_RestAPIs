package com.retsapis.blogging_application.repository;

import com.retsapis.blogging_application.entities.Category;
import com.retsapis.blogging_application.entities.Post;
import com.retsapis.blogging_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);

    List<Post> findByCategory(Category category);


}
