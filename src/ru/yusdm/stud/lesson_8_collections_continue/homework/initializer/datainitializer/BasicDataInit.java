package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.HandWrittenBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.PrintedBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomExceptions;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;

/**
 * Created by Dinara Shabanova on 16.09.2019.
 */
public interface BasicDataInit  {
    default Book valueOfBook(String type, InputBook inputBook) throws CustomExceptions{
        Book book = null;
        try {
            if ("printed".equalsIgnoreCase(type)) {
                book = new PrintedBook();
            } else if ("hand".equalsIgnoreCase(type)) {
                book = new HandWrittenBook();
            } else if (type == null) {
                book = new Book();
            } else {
                throw new CustomExceptions("Unknown type of book");
            }
            book.setName(inputBook.getName());
            book.setPublishYear(inputBook.getPublishYear());
            book.setTotalPages(inputBook.getTotalPages());
            book.setBookGenre(inputBook.getBookGenre());
        } catch (CustomExceptions e) {
            System.out.println(e.getMessage());
        }
        return book;
    }
    default Author valueOfInputAuthor(InputAuthor inputAuthor){
        Author author = new Author(null);
        author.setLastName(inputAuthor.getLastName());
        author.setName(inputAuthor.getName());
        author.setYearOfBorn(inputAuthor.getYearOfBorn());

        return author;
    };
}
