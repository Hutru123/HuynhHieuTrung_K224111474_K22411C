package com.example.midtermapplication.model;

public class Task {
    public String title;
    public String description;
    public boolean isCompleted;

    public Task(String title, String description, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }
}