package com.example.model;

import java.time.LocalDateTime;

public class NoteBuilder {
    private String title;
    private String content;
    private LocalDateTime dateTime;

    public NoteBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder setContent(String content) {
        this.content = content;
        return this;
    }

    public NoteBuilder setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    public Note build() {
        return new Note(title, content, dateTime);
    }
}
