package ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.*;

import java.util.List;

public interface BookRepo extends BaseRepo<Book> {
    int count();
  /*  void print();
    void delete(Book book);
    Long add(Book book);*/
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsList(long authorId);
}
