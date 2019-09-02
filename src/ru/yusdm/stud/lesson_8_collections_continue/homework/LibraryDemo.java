package ru.yusdm.stud.lesson_8_collections_continue.homework;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.InputAuthor;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoArrayImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoCollectionImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorServiceImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.HandWrittenBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.PrintedBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoArrayImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoCollectionImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;

public class LibraryDemo {

    public static void main(String[] args) {
//        String storageType = "arrays";
        String storageType = "collection";
        BookRepo bookRepo = null;
        AuthorRepo authorRepo = null;

        if (storageType.equals("arrays")){
            bookRepo = new BookRepoArrayImpl();
            authorRepo = new AuthorRepoArrayImpl();
        }else if (storageType.equals("collection")){
            bookRepo = new BookRepoCollectionImpl();
            authorRepo = new AuthorRepoCollectionImpl();
        }

        AuthorService authorService = new AuthorServiceImpl(authorRepo, bookRepo);
        BookService bookService = new BookServiceImpl(bookRepo);
        initData(bookService, authorService);

        bookService.print();
        authorService.print();

    }

    private static void initData(BookService bookService, AuthorService authorService) {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(11);
        Book book1 = valueOfForHandWrittenBook(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Rusla and Ludmila");
        inputBook2.setPublishYear(11);
        Book book2 = valueOfForHandWrittenBook(inputBook2);

        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setLastName("Pushkin");
        inputAuthor.setYearOfBorn(22);
        Author author = valueOfForHandWrittenBook(inputAuthor);
        author.setBooks(new ArrayList<>(Arrays.asList(book1, book2)));

        book1.setAuthors(new ArrayList<>(Arrays.asList(author)));
        book2.setAuthors(new ArrayList<>(Arrays.asList(author)));


        bookService.add(book1);
        bookService.add(book2);

        //AuthorRepo
        authorService.add(author);
    }

    private static Book valueOfForHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setPaint(inputBook.getPaint());

        return book;
    }

    private static Book valueOfForPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setFontFamily(inputBook.getFontFamily());

        return book;
    }

    private static Author valueOfForHandWrittenBook(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        return author;
    }
}
