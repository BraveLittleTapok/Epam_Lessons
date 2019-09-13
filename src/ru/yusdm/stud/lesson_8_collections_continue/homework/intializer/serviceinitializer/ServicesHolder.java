package src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.serviceinitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class ServicesHolder {

    private final BookService bookService;
    private final AuthorService authorService;

    public ServicesHolder(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    public BookService getBookService() {
        return bookService;
    }

    public AuthorService getAuthorService() {
        return authorService;
    }
}
