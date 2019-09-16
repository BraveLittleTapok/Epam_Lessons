package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils;
/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class InMemoryInitializer extends BasicDataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;

    public InMemoryInitializer(ServicesHolder servicesHolder) {
        super(servicesHolder);
        authorService = servicesHolder.getAuthorService();
        this.bookService = servicesHolder.getBookService();
    }

    @Override
    public void initData() {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setPublishYear(11);
        Book book1 = valueOfInputHandWrittenBook(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Rusla and Ludmila");
        inputBook2.setPublishYear(11);
        Book book2 = valueOfInputHandWrittenBook(inputBook2);

        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setLastName("Pushkin");
        inputAuthor.setYearOfBorn(22);
        Author author = valueOfInputAuthor(inputAuthor);
        author.setBooks(CollectionUtils.mutableListOf(book1, book2));

        book1.setAuthors(CollectionUtils.mutableListOf(author, author));
        book2.setAuthors(CollectionUtils.mutableListOf(author));

        bookService.add(book1);
        bookService.add(book2);

        //AuthorRepo
        authorService.add(author);
    }
}
