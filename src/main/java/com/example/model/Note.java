package com.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Note implements Serializable {
    private String title;
    private String content;
    private LocalDateTime dateTime;

    public Note(String title, String content, LocalDateTime dateTime) {
        this.title = title;
        this.content = content;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Content: " + content + ", DateTime: " + dateTime;
    }
}
