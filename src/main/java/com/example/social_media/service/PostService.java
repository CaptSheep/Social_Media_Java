package com.example.social_media.service;

import com.example.social_media.model.Post;

import java.util.Optional;

public interface PostService extends BaseInterface<Post> {
    Optional<Post> findByContent(String content);
    Optional<Post> findByStatus(String status);
}
