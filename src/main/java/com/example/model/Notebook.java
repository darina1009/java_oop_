package com.example.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Notebook<T extends Note> implements Iterable<T>, Serializable {
    private List<T> notes;

    public Notebook() {
        this.notes = new ArrayList<>();
    }

    public void addNote(T note) {
        notes.add(note);
    }

    public List<T> getNotes() {
        return notes;
    }

    public void sortByTitle() {
        notes.sort(Comparator.comparing(Note::getTitle));
    }

    public void sortByDateTime() {
        notes.sort(Comparator.comparing(Note::getDateTime));
    }

    public List<T> findNotesByDate(LocalDateTime date) {
        return notes.stream()
                .filter(note -> note.getDateTime().toLocalDate().equals(date.toLocalDate()))
                .collect(Collectors.toList());
    }

    public List<T> findNotesByWeek(LocalDateTime date) {
        LocalDateTime startOfWeek = date.toLocalDate().with(java.time.DayOfWeek.MONDAY).atStartOfDay();
        LocalDateTime endOfWeek = startOfWeek.plusDays(6).plusHours(23).plusMinutes(59).plusSeconds(59);

        return notes.stream()
                .filter(note -> note.getDateTime().isAfter(startOfWeek) && note.getDateTime().isBefore(endOfWeek))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return notes.iterator();
    }
}
