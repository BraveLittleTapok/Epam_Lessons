package src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;

import java.util.List;

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
}
