package com.hsbc.demo.controller;

import com.hsbc.demo.exception.ResourceNotFoundException;
import com.hsbc.demo.model.Post;
import com.hsbc.demo.model.ResponseInfo;
import com.hsbc.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getUserPosts(@PathVariable(value = "userId") Long userId) {
        return postRepository.findByUserIdOrderByCreatedTimeDesc(userId);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<ResponseInfo> getPostById(@PathVariable(value = "id") Long postId)
            throws ResourceNotFoundException {
        Post post =
                postRepository
                        .findById(postId)
                        .orElseThrow(() -> new ResourceNotFoundException("Post not found on :: " + postId));
        ResponseInfo response = new ResponseInfo<Post>();
        response.setData(post);
        response.setStatus(HttpStatus.OK);
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/post")
    public ResponseEntity<ResponseInfo> createPost(@Valid @RequestBody Post post) {
        ResponseInfo response = null;
        Post postInfo = postRepository.save(post);
        response = new ResponseInfo<Post>();
        response.setStatus(HttpStatus.OK);
        response.setData(postInfo);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable(value = "id") Long postId, @Valid @RequestBody Post postDetails)
            throws ResourceNotFoundException {

        Post user =
                postRepository
                        .findById(postId)
                        .orElseThrow(() -> new ResourceNotFoundException("Post not found on :: " + postId));

        user.setContent(postDetails.getContent());
        user.setPicture(postDetails.getPicture());
        user.setLikes(postDetails.getLikes());
        user.setDislikes(postDetails.getDislikes());
        user.setUpdatedTime(new Date());
        user.setStatus(postDetails.isStatus());
        final Post updatedUser = postRepository.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/post/{id}")
    public Map<String, Object> deletePost(@PathVariable(value = "id") Long postId) throws Exception {
        Post user =
                postRepository
                        .findById(postId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + postId));
        user.setStatus(false);
        final Post deletedPost = postRepository.save(user);
        Map<String, Object> response = new HashMap<>();
        response.put("deleted", deletedPost);
        return response;
    }
}
