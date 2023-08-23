package com.retsapis.blogging_application.servies.serviesImplementation;

import com.retsapis.blogging_application.entities.Category;
import com.retsapis.blogging_application.exception.ResourceNotFoundException;
import com.retsapis.blogging_application.payloads.CategoryDto;
import com.retsapis.blogging_application.repository.CategoryRepo;
import com.retsapis.blogging_application.servies.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category category1 = this.categoryRepo.save(category);
        return this.modelMapper.map(category1, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));

        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category category1 = this.categoryRepo.save(category);
        return this.modelMapper.map(category1, CategoryDto.class);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));

        return this.modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategory() {

        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtoList = categories.stream().map((cat)-> this.modelMapper.map(cat, CategoryDto.class))
                .collect(Collectors.toList());

        return categoryDtoList;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));

        this.categoryRepo.delete(category);

    }
}
