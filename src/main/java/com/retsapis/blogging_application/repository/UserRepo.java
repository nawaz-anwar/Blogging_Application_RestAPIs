package com.retsapis.blogging_application.repository;

import com.retsapis.blogging_application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
