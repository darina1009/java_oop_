package com.example.service;

import java.util.List;

public interface SerializableService<T> {
    void saveToFile(List<T> data, String filePath);
    List<T> loadFromFile(String filePath);
}
