package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.HandWrittenBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.PrintedBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.util.List;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public abstract class BasicDataInitializer {
    protected final ServicesHolder servicesHolder;

    protected BasicDataInitializer(ServicesHolder servicesHolder) {
        this.servicesHolder = servicesHolder;
    }

    public abstract void initData() throws Exception;

    protected Book valueOfInputHandWrittenBook(InputBook inputBook) {
        HandWrittenBook book = new HandWrittenBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setPaint(inputBook.getPaint());
        book.setBookGenre(inputBook.getBookGenre());

        return book;
    }

    protected Book valueOfInputPrintedBook(InputBook inputBook) {
        PrintedBook book = new PrintedBook();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setFontFamily(inputBook.getFontFamily());
        book.setBookGenre(inputBook.getBookGenre());
        return book;
    }

    protected static void updateListOfAuthorsForBook(Book bookAlreadyExist, Author newAuthor) {
        List<Author> authorsBookAlreadyHas = bookAlreadyExist.getAuthors();
        authorsBookAlreadyHas.add(newAuthor);
        bookAlreadyExist.setAuthors(authorsBookAlreadyHas);
    }

    protected static Book valueOfBook(String type, InputBook inputBook) throws CustomException {
        Book book = null;
        try {
            String trimType = type.trim();
            if ("printed".equalsIgnoreCase(trimType)) {
                book = new PrintedBook();
            } else if ("hand".equalsIgnoreCase(trimType)) {
                book = new HandWrittenBook();
            } else if (type == null || stringIsEmpty(trimType)) {
                book = new Book();
            } else {
                throw new CustomException("Unknown type of book");
            }
            book.setName(inputBook.getName());
            book.setPublishYear(inputBook.getPublishYear());
            book.setBookGenre(inputBook.getBookGenre());
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    protected static Author valueOfInputAuthor(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setName(inputAuthor.getName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());

        return author;
    }

    private static boolean stringIsEmpty(String str){
        String returnString = str.replace(" ", "");
        return returnString.length() == 0 ? true : false;
    }

}
