package com.retsapis.blogging_application.controllers;

import com.retsapis.blogging_application.config.AppConstants;
import com.retsapis.blogging_application.payloads.ApiResponse;
import com.retsapis.blogging_application.payloads.PostDto;
import com.retsapis.blogging_application.payloads.PostResponse;
import com.retsapis.blogging_application.servies.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}")
    public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto,
                                              @PathVariable Integer userId, @PathVariable Integer categoryId){

        PostDto createPostDto = this.postService.createPost(postDto, userId, categoryId);

        return new ResponseEntity<PostDto>(createPostDto, HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDto> updatePost(@Valid @RequestBody PostDto postDto, @PathVariable Integer postId){

        PostDto updatePostDto = this.postService.updatePost(postDto, postId);

        return new ResponseEntity<PostDto>(updatePostDto, HttpStatus.OK);
    }


    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId){

        List<PostDto> postDto =  this.postService.getPostByUser(userId);

        return new ResponseEntity<>(postDto, HttpStatus.OK);

    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<PostDto>> getPostByCategoryId(@PathVariable Integer categoryId){

        List<PostDto> postDto = this.postService.getPostByCategory(categoryId);

        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.SORT_DIR, required = false) String sortDir) {

        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize, sortBy, sortDir);
        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        this.postService.deletePost(postId);

        return new ApiResponse("Post deleted successfully", true);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){

        PostDto postDtos = this.postService.getPostById(postId);

        return new ResponseEntity<PostDto>(postDtos, HttpStatus.OK);

    }
}
