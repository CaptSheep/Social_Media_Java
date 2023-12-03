package com.example.social_media.repository;

import com.example.social_media.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    Optional<Post> findAllByContentContaining(String content);

    Optional<Post> findAllByStatus(String status);
}
