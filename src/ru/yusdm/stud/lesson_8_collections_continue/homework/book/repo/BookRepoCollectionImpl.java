package ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * Java------------
 * List<Book> list
 * 1 - Pushkin = b1;
 *
 * list.remove(b1);
 *
 * ---------------
 * Go to file
 * Read 1 - Pushkin = b1; => BookObject = bo
 *
 * list(bo)
 *
 * forEach(if ID == bo.id){
 *     remove!!
 * }
 *
 *
 */
public class BookRepoCollectionImpl implements BookRepo   {

    final EntityRepo entity = new EntityRepoImpl();
    @Override
    public int count() {
        return CollectionStorage.getTotalBooks();
    }

    @Override
    public void print() {
        entity.print(CollectionStorage.getAllBooks());
    }

    @Override
    public void delete(Book book) {
        entity.delete(book, CollectionStorage.getAllBooks());
    }

    @Override
    public Long add(Book element) {
        return entity.add(element, CollectionStorage.getAllBooks());
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        List<Book> found = new ArrayList<>();

        for (Book b : CollectionStorage.getAllBooks()) {

            List<Author> authors = b.getAuthors();
            for (Author a : authors) {
                if (a != null && authorId == a.getId()) {
                    found.add(b);
                    break;
                }
            }

        }

        return found;
    }

}
