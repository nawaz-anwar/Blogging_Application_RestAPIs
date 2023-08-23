package com.retsapis.blogging_application.repository;

import com.retsapis.blogging_application.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
