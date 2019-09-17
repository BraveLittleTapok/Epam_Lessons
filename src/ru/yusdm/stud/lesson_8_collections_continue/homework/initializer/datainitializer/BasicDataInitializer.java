package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.*;

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

    public static Book valueOfBook(String type, InputBook inputBook) throws CustomException {
        Book book = null;
        try {
            if ("printed".equalsIgnoreCase(type)) {
                book = new PrintedBook();
            } else if ("hand".equalsIgnoreCase(type)) {
                book = new HandWrittenBook();
            } else if (type == null) {
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

    public static Author valueOfInputAuthor(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setName(inputAuthor.getName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());

        return author;
    }

  /*  protected Map<String, Author> valueOfInputAuthors(Collection<InputAuthor> parsedAuthors) {
        Map<String, Author> result = new LinkedHashMap<>();
        for (InputAuthor parsedAuthor : parsedAuthors) {
            result.put(parsedAuthor.get, valueOfInputAuthor(parsedAuthor));
        }
        return result;
    }*/

}
