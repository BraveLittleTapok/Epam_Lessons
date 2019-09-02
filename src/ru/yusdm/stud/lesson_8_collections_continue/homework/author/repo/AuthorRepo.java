package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;

public interface AuthorRepo {
    int count();
    void print();
    void delete(Author author);
    Long add(Author author);
}
