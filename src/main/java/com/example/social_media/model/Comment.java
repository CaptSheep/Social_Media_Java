package com.example.social_media.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @CreationTimestamp
    private Date createAt;

    @ManyToOne
    @JoinColumn(name = "users",nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "posts" , nullable = false)
    private Post post;

    public Comment() {
    }

    public Comment(Long id, String content, Date createAt, User user, Post post) {
        this.id = id;

        this.content = content;
        this.createAt = createAt;
        this.user = user;
        this.post = post;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
