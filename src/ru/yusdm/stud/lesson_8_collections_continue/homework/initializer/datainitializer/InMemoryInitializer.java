package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class InMemoryInitializer extends BasicDataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;

    public InMemoryInitializer(ServicesHolder servicesHolder) throws Exception {
        super(servicesHolder);
        authorService = servicesHolder.getAuthorService();
        this.bookService = servicesHolder.getBookService();
    }

    @Override
    public List<Author> getParsedData() throws IOException, CustomException {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(11);
        Book book1 = valueOfBook("hand",inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Rusla and Ludmila");
        inputBook2.setPublishYear(11);
        Book book2 = valueOfBook("printed",inputBook2);

        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setLastName("Pushkin");
        inputAuthor.setYearOfBorn(22);
        Author author = valueOfInputAuthor(inputAuthor);
        author.setBooks(CollectionUtils.mutableListOf(book1, book2));

        List<Author> authors = new ArrayList<>();
        authors.add(author);

        inputBook2.setName("Cat");
        inputBook2.setPublishYear(2000);
        book1 = valueOfBook("printed",inputBook2);

        inputAuthor = new InputAuthor();
        inputAuthor.setLastName("Ivanov");
        inputAuthor.setYearOfBorn(1990);
        author = valueOfInputAuthor(inputAuthor);
        author.setBooks(CollectionUtils.mutableListOf(book1));
        authors.add(author);
        return authors;
    }
}

