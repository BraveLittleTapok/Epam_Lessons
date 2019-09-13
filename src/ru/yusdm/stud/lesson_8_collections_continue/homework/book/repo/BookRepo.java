package src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.BaseRepo;

import java.util.List;

public interface BookRepo extends BaseRepo<Book, Long> {
    Book[] findBooksByAuthorAsArray(long authorId);
    List<Book> findBooksByAuthorAsList(long authorId);
    List<Book> getAllBooks ();
}
