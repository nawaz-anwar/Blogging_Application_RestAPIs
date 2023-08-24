package com.retsapis.blogging_application.servies;

import com.retsapis.blogging_application.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDto createCategory(CategoryDto categoryDto);

    //update
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //getCategoryById
    CategoryDto getCategoryById(Integer categoryId);

    //getAllCategory
    List<CategoryDto> getAllCategory();

    //delete
    void deleteCategory(Integer categoryId);
}
