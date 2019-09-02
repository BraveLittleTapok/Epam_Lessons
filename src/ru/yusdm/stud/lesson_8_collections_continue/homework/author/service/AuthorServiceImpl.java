package ru.yusdm.stud.lesson_8_collections_continue.homework.author.service;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.BaseRepo;

public class AuthorServiceImpl implements AuthorService, BaseRepo<Author> {

    private final AuthorRepo authorRepo;
    private final BookRepo bookRepo;

    public AuthorServiceImpl(AuthorRepo authorRepo,
                             BookRepo bookRepo) {
        this.authorRepo = authorRepo;
        this.bookRepo = bookRepo;
    }

    @Override
    public int count() {
        return authorRepo.count();
    }

    @Override
    public void deleteBooksWhichOldAndSentReport() {

    }

    @Override
    public void print() {
        authorRepo.print();
    }
    /**
     * When delete Author
     * <p>
     * Look for books where author present, and remove him from book
     * <p>
     * if (book.getAuthorCount == 0){
     * dropBook()
     * }
     * <p>
     * <p>
     * ----------
     * When delete book
     * Delete book from storage
     */
    @Override
    public void delete(Author author) {
        Book[] booksWithAuthor = bookRepo.findBooksByAuthorAsArray(author.getId());

        if (booksWithAuthor != null) {
            for (Book book : booksWithAuthor) {
                book.deleteAuthor(author);

                if (book.withoutAuthors()) {
                    bookRepo.delete(book);
                }
            }
        }

        authorRepo.delete(author);

    }

    @Override
    public Long add(Author author) {
        return authorRepo.add(author);
    }

}
