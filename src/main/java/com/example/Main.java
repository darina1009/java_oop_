package com.example;

import com.example.model.Note;
import com.example.model.Notebook;
import com.example.presenter.Presenter;
import com.example.presenter.UserInteraction;
import com.example.service.FileService;
import com.example.service.NotebookService;
import com.example.view.ConsoleView;
import com.example.view.View;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleView();
        Notebook<Note> notebook = new Notebook<>();
        FileService fileService = new FileService();
        NotebookService notebookService = new NotebookService(notebook, fileService);
        Presenter presenter = new Presenter(view, notebookService);
        UserInteraction userInteraction = new UserInteraction(presenter, view);

        userInteraction.start();
    }
}