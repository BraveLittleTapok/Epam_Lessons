package src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.HandWrittenBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.PrintedBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.author.InputAuthor;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.book.InputBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.serviceinitializer.ServicesHolder;

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


    protected Book valueOfBook(InputBook inputBook) {
        Book book = new Book();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setBookGenre(inputBook.getBookGenre());
        return book;
    }
    protected Author valueOfInputAuthor(InputAuthor inputAuthor) {
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
