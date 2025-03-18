package com.example.todoapi.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
/*import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;*/

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private String name;
    private String description;
    private boolean done;
    private int priority;
    private LocalDateTime creationDate = LocalDateTime.now();
    private LocalDateTime updateDate;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public boolean isDone() {
        return done;
    }
    public void setDone(boolean done) {
        this.done = done;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public LocalDateTime getDate() {
        return creationDate;
    }
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }
}