package com.example.service;

import com.example.model.Note;
import com.example.model.NoteBuilder;
import com.example.model.Notebook;
import java.time.LocalDateTime;
import java.util.List;

public class NotebookService {
    private Notebook<Note> notebook;
    private FileService fileService;

    public NotebookService(Notebook<Note> notebook, FileService fileService) {
        this.notebook = notebook;
        this.fileService = fileService;
    }

    public void addNote(String title, String content, LocalDateTime dateTime) {
        Note note = new NoteBuilder()
                .setTitle(title)
                .setContent(content)
                .setDateTime(dateTime)
                .build();
        notebook.addNote(note);
    }

    public List<Note> getNotes() {
        return notebook.getNotes();
    }

    public void sortByTitle() {
        notebook.sortByTitle();
    }

    public void sortByDateTime() {
        notebook.sortByDateTime();
    }

    public List<Note> findNotesByDate(LocalDateTime date) {
        return notebook.findNotesByDate(date);
    }

    public List<Note> findNotesByWeek(LocalDateTime date) {
        return notebook.findNotesByWeek(date);
    }

    public void saveData(String filePath) {
        fileService.saveToFile(notebook.getNotes(), filePath);
    }

    public void loadData(String filePath) {
        List<Note> notes = fileService.loadFromFile(filePath);
        if (notes != null) {
            notebook.getNotes().clear();
            notebook.getNotes().addAll(notes);
        }
    }
}
