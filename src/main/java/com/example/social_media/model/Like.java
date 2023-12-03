package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "users",nullable = false)
    private Users users;
    @ManyToOne
    @JoinColumn(name = "posts",nullable = false)
    private Posts posts;

    private int totalLike;


    public Like() {
    }

    public Like(Long id, Users users, Posts posts, int totalLike) {
        this.id = id;
        this.users = users;
        this.posts = posts;
        this.totalLike = totalLike;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Posts getPosts() {
        return posts;
    }

    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    public int getTotalLike() {
        return totalLike;
    }

    public void setTotalLike(int totalLike) {
        this.totalLike = totalLike;
    }
}
