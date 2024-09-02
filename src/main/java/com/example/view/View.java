package com.example.view;

import com.example.model.Note;
import java.util.List;

public interface View {
    void displayNotes(List<Note> notes);
    void displayError(String message);
    void displayMessage(String message);
    String getInput(String prompt);
}
