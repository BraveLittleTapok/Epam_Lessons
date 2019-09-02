package ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo;

/**
 * Created by Dinara Shabanova on 02.09.2019.
 */
public interface BaseRepo<T> {
    int count();
    void print();
    void delete(T element);
    Long add(T element);
}
