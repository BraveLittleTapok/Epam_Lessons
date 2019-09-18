package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.HandWrittenBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.PrintedBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.File;
import java.util.List;

import static ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils.mutableListOf;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public abstract class BasicDataInitializer {
    protected final ServicesHolder servicesHolder;
    private List<Author> authors = getParsedData();

    protected BasicDataInitializer(ServicesHolder servicesHolder) throws Exception {
        this.servicesHolder = servicesHolder;
    }

    public void initData() {
        for (Author author : authors) {
            this.servicesHolder.getAuthorService().add(author);
            for (Book bookToAdd : author.getBooks()) {
                bookToAdd.setAuthors(mutableListOf(author));
                if (this.servicesHolder.getBookService().count() == 0) { //if storage is empty
                    this.servicesHolder.getBookService().add(bookToAdd);
                } else {
                    boolean newBookAddedInLibrary = false;
                    for (Book bookAlreadyInStorage : this.servicesHolder.getBookService().getAllBooks()) {  //if book has several authors
                        if (bookToAdd.getName().equalsIgnoreCase(bookAlreadyInStorage.getName())) {
                            updateListOfAuthorsForBook(bookAlreadyInStorage, author);
                            newBookAddedInLibrary = true;
                        }
                    }
                    if (!newBookAddedInLibrary) {
                        this.servicesHolder.getBookService().add(bookToAdd);
                    }
                }
            }
        }
    }

    public abstract List<Author> getParsedData() throws Exception;

    protected static void updateListOfBooksForAuthor(Author authorAlreadyExist, Book book) {
        List<Book> booksAlreadyAddInAuthor = authorAlreadyExist.getBooks();
        booksAlreadyAddInAuthor.add(book);
        authorAlreadyExist.setBooks(booksAlreadyAddInAuthor);
        book.setAuthors(mutableListOf(authorAlreadyExist));
    }

    protected static void updateListOfAuthorsForBook(Book bookAlreadyExist, Author newAuthor) {
        List<Author> authorsBookAlreadyHas = bookAlreadyExist.getAuthors();
        authorsBookAlreadyHas.add(newAuthor);
        bookAlreadyExist.setAuthors(authorsBookAlreadyHas);
    }

    protected static Book valueOfBook(String type, InputBook inputBook) throws CustomException {
        Book book;
        try {
            String trimType = type.trim();
            if ("printed".equalsIgnoreCase(trimType)) {
                book = new PrintedBook();
            } else if ("hand".equalsIgnoreCase(trimType)) {
                book = new HandWrittenBook();
            } else if (type == null || (trimType.length() == 0)) {
                throw new NullPointerException();
            } else {
                throw new CustomException("Unknown type of book");
            }
        } catch (NullPointerException e) {
            book = new Book();
        }
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setBookGenre(inputBook.getBookGenre());
        return book;
    }

    protected static Author valueOfInputAuthor(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setName(inputAuthor.getName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());

        return author;
    }

    protected static boolean isFileValid(File file) {
        return file != null && file.isFile() && file.exists();
    }

}
