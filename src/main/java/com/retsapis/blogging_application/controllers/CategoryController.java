package com.retsapis.blogging_application.controllers;

import com.retsapis.blogging_application.payloads.ApiResponse;
import com.retsapis.blogging_application.payloads.CategoryDto;
import com.retsapis.blogging_application.servies.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){

        CategoryDto createCategoryDto = this.categoryService.createCategory(categoryDto);

        return new ResponseEntity<CategoryDto>(createCategoryDto, HttpStatus.CREATED);
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable Integer categoryId){

        CategoryDto updateCategoryDto = this.categoryService.updateCategory(categoryDto, categoryId);

        return ResponseEntity.ok(updateCategoryDto);
    }

    @GetMapping("/")
    public List<CategoryDto> getAllCategory(){

        return this.categoryService.getAllCategory();
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
        CategoryDto categoryDto = this.categoryService.getCategoryById(categoryId);

        return ResponseEntity.ok(categoryDto);
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
        this.categoryService.deleteCategory(categoryId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted Successfully", true), HttpStatus.OK);
    }
}
