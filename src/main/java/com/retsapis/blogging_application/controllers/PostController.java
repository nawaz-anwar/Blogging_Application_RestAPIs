package com.retsapis.blogging_application.controllers;

import com.retsapis.blogging_application.payloads.PostDto;
import com.retsapis.blogging_application.servies.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable Integer userId, @PathVariable Integer categoryId){

        PostDto createPostDto = this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<>(createPostDto, HttpStatus.CREATED);
    }
}
