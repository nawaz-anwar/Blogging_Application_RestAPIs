package com.retsapis.blogging_application.servies;

import com.retsapis.blogging_application.payloads.PostDto;

import java.util.List;

public interface PostService {

    //create
    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update
    PostDto updatePost(PostDto postDto, Integer postId);

    //delete
    void deletePost(Integer postId);

    //get post by id
    PostDto getPostById(Integer postId);

    //get all post by category
    List<PostDto> getPostByCategory(Integer categoryId);

    //get all post by user
    List<PostDto> getPostByUser(Integer userId);

    //search posts
    List<PostDto> searchPost(String keyword);

}
