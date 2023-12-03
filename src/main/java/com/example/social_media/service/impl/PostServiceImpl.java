package com.example.social_media.service.impl;

import com.example.social_media.model.Post;
import com.example.social_media.repository.PostRepository;
import com.example.social_media.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> findAll() {
        return  postRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Optional<Post> findByContent(String content) {
        return postRepository.findAllByContentContaining(content);
    }

    @Override
    public Optional<Post> findByStatus(String status) {
        return postRepository.findAllByStatus(status);

    }
}
