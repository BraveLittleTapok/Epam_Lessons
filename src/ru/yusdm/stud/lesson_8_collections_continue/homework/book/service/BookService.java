package ru.yusdm.stud.lesson_8_collections_continue.homework.book.service;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;

import java.util.List;

public interface BookService {
    int count();
    void print();
    void delete(Book book);
    Long add(Book book);
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsList(long authorId);
}
