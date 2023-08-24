package com.retsapis.blogging_application.servies.serviesImplementation;

import com.retsapis.blogging_application.entities.Category;
import com.retsapis.blogging_application.entities.Post;
import com.retsapis.blogging_application.entities.User;
import com.retsapis.blogging_application.exception.ResourceNotFoundException;
import com.retsapis.blogging_application.payloads.PostDto;
import com.retsapis.blogging_application.repository.CategoryRepo;
import com.retsapis.blogging_application.repository.PostRepo;
import com.retsapis.blogging_application.repository.UserRepo;
import com.retsapis.blogging_application.servies.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

        User user = this.userRepo.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));

        Category category = this.categoryRepo.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category", "Category Id", categoryId));

        Post post = this.modelMapper.map(postDto, Post.class);
        post.setPostImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepo.save(post);

        return this.modelMapper.map(newPost, PostDto.class);

    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "Post Id", postId));

        Category category = this.categoryRepo.findById(postDto.getCategory().getCategoryId()).get();

        post.setPostTitle(postDto.getPostTitle());
        post.setPostContent(postDto.getPostContent());
        post.setPostImageName(post.getPostImageName());

        Post post1 = this.postRepo.save(post);

        return this.modelMapper.map(post1, PostDto.class);

    }

    @Override
    public void deletePost(Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));

        this.postRepo.delete(post);

    }

    @Override
    public PostDto getPostById(Integer postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(()-> new ResourceNotFoundException("Post", "PostId", postId));
        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        return null;
    }

    @Override
    public List<PostDto> searchPost(String keyword) {
        return null;
    }
}
