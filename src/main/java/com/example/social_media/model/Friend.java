package com.example.social_media.model;

import jakarta.persistence.*;

@Entity
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userSend",nullable = false)
    private User userSend;
    @ManyToOne
    @JoinColumn(name = "userReceive",nullable = false)
    private User userReceive;

    private String status;

    public Friend() {
    }

    public Friend(Long id, User userSend, User userReceive, String status) {
        this.id = id;
        this.userSend = userSend;
        this.userReceive = userReceive;
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getUserSend() {
        return userSend;
    }

    public void setUserSend(User userSend) {
        this.userSend = userSend;
    }

    public User getUserReceive() {
        return userReceive;
    }

    public void setUserReceive(User userReceive) {
        this.userReceive = userReceive;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
