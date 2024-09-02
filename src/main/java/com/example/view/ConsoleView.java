package com.example.view;

import com.example.model.Note;
import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayNotes(List<Note> notes) {
        for (Note note : notes) {
            System.out.println(note);
        }
    }

    @Override
    public void displayError(String message) {
        System.err.println(message);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }
}
