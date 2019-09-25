package ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo;

import java.util.Comparator;
import java.util.List;

public interface BaseRepo<T, ID> {
    int count();

    void print();

    void delete(T t);

    ID add(T t);

    T findById(ID id);

    List<T> sort(List<T> itemsToSort, Comparator<T> comparator);
}
