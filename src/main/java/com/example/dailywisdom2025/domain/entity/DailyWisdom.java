package com.example.dailywisdom2025.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dailywisdom")
public class DailyWisdom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "message", length = Integer.MAX_VALUE)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}