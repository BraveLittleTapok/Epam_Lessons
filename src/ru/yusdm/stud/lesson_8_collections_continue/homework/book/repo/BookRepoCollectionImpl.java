package ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * Java------------
 * List<Book> list
 * 1 - Pushkin = b1;
 * <p>
 * list.remove(b1);
 * <p>
 * ---------------
 * Go to file
 * Read 1 - Pushkin = b1; => BookObject = bo
 * <p>
 * list(bo)
 * <p>
 * forEach(if ID == bo.id){
 * remove!!
 * }
 */
public class BookRepoCollectionImpl implements BookRepo {

    @Override
    public int count() {
        return CollectionStorage.getTotalBooks();
    }

    @Override
    public void print() {
        for (Book book : CollectionStorage.getAllBooks()) {
            if (book != null) {
                System.out.println(book.toString());
            }
        }
    }

    @Override
    public void delete(Book book) {
        CollectionStorage.removeBook(book);
    }

    @Override
    public Long add(Book book) {
        CollectionStorage.addBook(book);
        return book.getId();
    }

    @Override
    public List<Book> getAllBooks() {
        return CollectionStorage.getAllBooks();
    }

    @Override
    public Book findById(Long bookId) {
        for (Book book : CollectionStorage.getAllBooks()) {
            if (book != null && bookId.equals(book.getId())) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return findBooksByAuthorAsList(authorId).toArray(new Book[0]);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        List<Book> found = new ArrayList<>();

        for (Book b : CollectionStorage.getAllBooks()) {

            for (Author a : b.getAuthors()) {
                if (a != null && authorId == a.getId()) {
                    found.add(b);
                    break;
                }
            }

        }

        return found;
    }

}
