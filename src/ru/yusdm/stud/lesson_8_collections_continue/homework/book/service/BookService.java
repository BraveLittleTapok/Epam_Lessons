package ru.yusdm.stud.lesson_8_collections_continue.homework.book.service;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.service.BaseService;

import java.util.List;

public interface BookService extends BaseService<Book, Long> {
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsList(long authorId);
    List<Book> getAllBooks();
    //List<Book> findByName(String name);
}
