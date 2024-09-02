package com.example.service;

import com.example.model.Note;
import java.io.*;
import java.util.List;

public class FileService implements SerializableService<Note> {
    @Override
    public void saveToFile(List<Note> data, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Note> loadFromFile(String filePath) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Note>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
