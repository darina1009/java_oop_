package com.example.presenter;

import com.example.model.Note;
import com.example.service.NotebookService;
import com.example.view.View;
import java.time.LocalDateTime;
import java.util.List;

public class Presenter {
    private View view;
    private NotebookService notebookService;

    public Presenter(View view, NotebookService notebookService) {
        this.view = view;
        this.notebookService = notebookService;
    }

    public void loadData(String filePath) {
        notebookService.loadData(filePath);
        view.displayNotes(notebookService.getNotes());
    }

    public void saveData(String filePath) {
        notebookService.saveData(filePath);
    }

    public void sortByTitle() {
        notebookService.sortByTitle();
        view.displayNotes(notebookService.getNotes());
    }

    public void sortByDateTime() {
        notebookService.sortByDateTime();
        view.displayNotes(notebookService.getNotes());
    }

    public void addNote() {
        String title = view.getInput("Enter title");
        String content = view.getInput("Enter content");
        LocalDateTime dateTime = LocalDateTime.parse(view.getInput("Enter date and time (YYYY-MM-DDTHH:MM)"));

        notebookService.addNote(title, content, dateTime);
        view.displayMessage("Note added successfully");
    }

    public void findNotesByDate() {
        LocalDateTime date = LocalDateTime.parse(view.getInput("Enter date (YYYY-MM-DD)"));
        List<Note> notes = notebookService.findNotesByDate(date);
        view.displayNotes(notes);
    }

    public void findNotesByWeek() {
        LocalDateTime date = LocalDateTime.parse(view.getInput("Enter date (YYYY-MM-DD)"));
        List<Note> notes = notebookService.findNotesByWeek(date);
        view.displayNotes(notes);
    }

    public void displayNotes() {
        view.displayNotes(notebookService.getNotes());
    }
}
