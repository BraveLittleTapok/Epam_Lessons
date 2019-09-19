package ru.yusdm.stud.lesson_8_collections_continue.homework.book.service;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class BookServiceImpl implements BookService {

    private final BookRepo bookRepo;

    @Override
    public List<Book> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public int count() {
        return bookRepo.count();
    }

    @Override
    public void print() {
        bookRepo.print();
    }

    @Override
    public void delete(Book book) {
        bookRepo.delete(book);
    }

    @Override
    public Long add(Book book) {
        return bookRepo.add(book);
    }

    @Override
    public Book findById(Long bookId) {
        if (bookId != null) {
            return bookRepo.findById(bookId);
        } else {
            return null;
        }
    }

    @Override
    public Book[] findBooksByAuthorAsArray(long authorId) {
        return bookRepo.findBooksByAuthorAsArray(authorId);
    }

    @Override
    public List<Book> findBooksByAuthorAsList(long authorId) {
        return bookRepo.findBooksByAuthorAsList(authorId);
    }


  /*  public List<Book> findBookByLambda(Predicate<Book> lambda) {
        List<Book> books = null;
        for (Book book : bookRepo.getAllBooks()) {
            if (lambda.test(book)) {
                return book;
            }
        }
        throw new NullPointerException("name not exist");
    }*/

   /* Book findBookByName(String name) {
        return ((Function<String, Book>) name1 -> {
            Book bookFind = null;
            for (Book book : bookRepo.getAllBooks()) {
                if (name1.equals(book.getName())) {
                    bookFind = book;
                }
            }
            if (bookFind == null) {
                throw new NullPointerException("Book with name: " + name1 + " doesn't exist");
            } else {
                return bookFind;
            }
        }).apply(name);
    }*/
}
