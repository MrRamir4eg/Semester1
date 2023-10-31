package ru.kpfu.itis.kashshapov.dao;

import java.util.List;

public interface Dao<T> {
    T getById(Long id);
    List<T> getAll();
    boolean add(T model);
    boolean update(T model);
    void delete(T model);
}
