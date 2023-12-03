package com.example.social_media.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    private String message;
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Message() {
    }

    public Message(Long id, Date createAt, String message, User user) {
        this.id = id;
        this.createAt = createAt;
        this.message = message;
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
