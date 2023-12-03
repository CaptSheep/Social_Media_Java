package com.example.social_media.controller;

import com.example.social_media.model.Post;
import com.example.social_media.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostServiceImpl postService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Post>> getListPost(){
        Iterable<Post> listPost = postService.findAll();
        return new ResponseEntity<>(listPost,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Post> createPost(@RequestBody Post post){
        postService.save(post);
        return new ResponseEntity<>(post,HttpStatus.CREATED);

    }
}
