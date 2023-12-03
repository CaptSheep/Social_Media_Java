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

    public Friend() {
    }

    public Friend(Long id, User userSend, User userReceive) {
        this.id = id;
        this.userSend = userSend;
        this.userReceive = userReceive;
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
}
