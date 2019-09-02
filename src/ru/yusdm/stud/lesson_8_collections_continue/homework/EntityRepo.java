package ru.yusdm.stud.lesson_8_collections_continue.homework;

import java.util.List;

/**
 * Created by Dinara Shabanova on 02.09.2019.
 */
public interface EntityRepo<T extends Entity> {
    Long add(T element, List<T> list);
    void delete(T element, List<T> list);
    void print(List list);

}
