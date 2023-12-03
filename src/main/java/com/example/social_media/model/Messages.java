package com.example.social_media.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity

public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createAt;
    private String message;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    private Users users;

    public Messages() {
    }

    public Messages(Long id, Date createAt, String message, Users users) {
        this.id = id;
        this.createAt = createAt;
        this.message = message;
        this.users = users;
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

    public Users getUser() {
        return users;
    }

    public void setUser(Users users) {
        this.users = users;
    }

}
