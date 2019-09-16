package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.BadBookTypeException;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomExceptions;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils.mutableListOf;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 * type of file
 * /* Author name lastname | Date of birth | Name of BOOK | publishYear | totalPages | BookGenre | BookType|
 * [0]                     [1]             [2]             [3]         [4]         [5]            [7]   => size = 7
 */
public class FileInitializer extends BasicDataInitializer {

    private static final String PATH = "/resource/ru/yusdm/stud/lesson_8_collections_continue/homework/DataLibrary.txt";

    public FileInitializer(ServicesHolder servicesHolder) {
        super(servicesHolder);
    }

    @Override
    public void initData() throws Exception {
        File fileWithInitData = FileUtils.createFileFromResource("java_core", "any", PATH);
        List<String> data = Files.readAllLines(Paths.get(fileWithInitData.getAbsolutePath()));
        parseFile(data);

    }

    private void parseFile(List<String> stringsFromFile) throws CustomExceptions {
        for (String str : stringsFromFile) {
            if (!str.contains("/*")) {
                //Split by |
                List<String> listOfStrings = new ArrayList<>(Arrays.asList(str.split("\\|")));
                deleteSplittedCharacter(listOfStrings);
                if (listOfStrings.size() == 7) {
                    Author newAuthor = valueOfInputAuthor(ParseString.getParseInputAuthor(listOfStrings));
                    Book newBook = valueOfInputBook(ParseString.getParseInputBook(listOfStrings));
                    if (this.servicesHolder.getAuthorService().count() == 0) {
                        addBookAndAuthorInStorage(newBook, newAuthor);
                    } else {
                        checkAndAddEntity(newAuthor, newBook);
                    }

                } else {
                    System.out.println("Something went wrong");
                    break;
                }
            }
        }
    }

    private void checkAndAddEntity(Author newAuthor, Book newBook) {
        boolean authorAlreadyInLibrary = false;
        boolean newBookAddedInLibrary = false;
        for (Author authorAlreadyExist : this.servicesHolder.getAuthorService().getAllAuthors()) {
            if (newAuthor.getLastName().equals(authorAlreadyExist.getLastName())) {
                updateListOfBooksForAuthor(authorAlreadyExist, newBook);
                this.servicesHolder.getBookService().add(newBook);
                authorAlreadyInLibrary = true;
                newBookAddedInLibrary = true;
            }
        }
        if (!authorAlreadyInLibrary) {
            for (Book bookAlreadyExist : this.servicesHolder.getBookService().getAllBooks()) {
                if (newBook.getName().equals(bookAlreadyExist.getName())) {
                    updateListOfAuthorsForBook(bookAlreadyExist, newAuthor);
                    this.servicesHolder.getAuthorService().add(newAuthor);
                    newBookAddedInLibrary = true;
                }
            }
            if (!newBookAddedInLibrary) {
                addBookAndAuthorInStorage(newBook, newAuthor);
            }
        }
    }


    private void updateListOfAuthorsForBook(Book bookAlreadyExist, Author newAuthor) {
        List<Author> authorsAlreadyAddInAuthor = bookAlreadyExist.getAuthors();
        authorsAlreadyAddInAuthor.add(newAuthor);
        bookAlreadyExist.setAuthors(authorsAlreadyAddInAuthor);
        newAuthor.setBooks(mutableListOf(bookAlreadyExist));
    }

    private void updateListOfBooksForAuthor(Author authorAlreadyExist, Book book) {
        List<Book> booksAlreadyAddInAuthor = authorAlreadyExist.getBooks();
        booksAlreadyAddInAuthor.add(book);
        authorAlreadyExist.setBooks(booksAlreadyAddInAuthor);
        book.setAuthors(mutableListOf(authorAlreadyExist));
    }

    private void deleteSplittedCharacter(List<String> listOfStrings) {
        Iterator<String> iter = listOfStrings.iterator();
        while (iter.hasNext()) {
            if (iter.next().contains("|")) {
                iter.remove();
            }
        }
    }

    private void addBookAndAuthorInStorage(Book book, Author author) {
        author.setBooks(mutableListOf(book));
        book.setAuthors(mutableListOf(author));
        this.servicesHolder.getBookService().add(book);
        this.servicesHolder.getAuthorService().add(author);
    }

    private Book valueOfInputBook(InputBook inputBook) throws CustomExceptions {
        return valueOfBook(inputBook.getBookFamily(), inputBook);
    }

}
