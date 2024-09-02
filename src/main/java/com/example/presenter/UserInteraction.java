package com.example.presenter;

import com.example.view.View;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class UserInteraction {
    private Presenter presenter;
    private View view;
    private Map<Integer, Consumer<Void>> actions;

    public UserInteraction(Presenter presenter, View view) {
        this.presenter = presenter;
        this.view = view;
        this.actions = new HashMap<>();
        initializeActions();
    }

    private void initializeActions() {
        actions.put(1, v -> presenter.displayNotes());
        actions.put(2, v -> presenter.sortByTitle());
        actions.put(3, v -> presenter.sortByDateTime());
        actions.put(4, v -> presenter.addNote());
        actions.put(5, v -> presenter.findNotesByDate());
        actions.put(6, v -> presenter.findNotesByWeek());
        actions.put(7, v -> presenter.loadData(view.getInput("Enter file path to load data")));
        actions.put(8, v -> presenter.saveData(view.getInput("Enter file path to save data")));
        actions.put(9, v -> {
            view.displayMessage("Exiting...");
            System.exit(0);
        });
    }

    public void start() {
        while (true) {
            view.displayMessage("Choose an action:");
            view.displayMessage("1. Display notes");
            view.displayMessage("2. Sort by title");
            view.displayMessage("3. Sort by date and time");
            view.displayMessage("4. Add note");
            view.displayMessage("5. Find notes by date");
            view.displayMessage("6. Find notes by week");
            view.displayMessage("7. Load data");
            view.displayMessage("8. Save data");
            view.displayMessage("9. Exit");

            int choice = Integer.parseInt(view.getInput("Enter your choice"));
            Consumer<Void> action = actions.get(choice);

            if (action != null) {
                action.accept(null);
            } else {
                view.displayError("Invalid choice. Please try again.");
            }
        }
    }
}
