package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
@Table(name = "likes")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "postId",nullable = false)
    private Post post;

    public Like() {
    }

    public Like(Long id, User user, Post post) {
        this.id = id;
        this.user = user;
        this.post = post;

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUsers() {
        return user;
    }

    public void setUsers(User user) {
        this.user = user;
    }

    public Post getPosts() {
        return post;
    }

    public void setPosts(Post post) {
        this.post = post;
    }


}
