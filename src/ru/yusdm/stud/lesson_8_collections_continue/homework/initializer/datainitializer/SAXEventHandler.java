package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.BookGenre;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomExceptions;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils.mutableListOf;

/**
 * Created by Dinara Shabanova on 16.09.2019.
 */
public class SAXEventHandler extends DefaultHandler implements BasicDataInit {
    public ServicesHolder servicesHolder;
    private BookService bookService;
    private AuthorService authorService;
    private Stack<String> stackOfTagsName = new Stack<>();
    private InputAuthor inputAuthor;
    private InputBook inputBook;
    private List<Book> books;
    private StringBuilder stringBuilder = new StringBuilder();

    public SAXEventHandler(ServicesHolder servicesHolder) {
        authorService = servicesHolder.getAuthorService();
        this.bookService = servicesHolder.getBookService();
        this.servicesHolder = servicesHolder;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case "author":
                inputAuthor = new InputAuthor();
                stackOfTagsName.push("author");
                break;
            case "books":
                books = new ArrayList<>();
                break;
            case "book":
                stackOfTagsName.push("book");
                inputBook = new InputBook();
                String type = attributes.getValue("type");
                inputBook.setBookFamily(type);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "author":
                Author author = valueOfInputAuthor(inputAuthor);
                author.setBooks(books);
                authorService.add(author);
                for (Book book: books) {
                    book.setAuthors(mutableListOf(author));
                    bookService.add(book);
                }
                break;
            case "name":
                if (stackOfTagsName.peek().equalsIgnoreCase("author")){
                    inputAuthor.setName(stringBuilder.toString());
                }else if (stackOfTagsName.peek().equalsIgnoreCase("book")){
                    inputBook.setName(stringBuilder.toString());
                }
                break;
            case "lastName":
                inputAuthor.setLastName(stringBuilder.toString());
                break;
            case "yearOfBirth":
                inputAuthor.setYearOfBorn(Integer.parseInt(stringBuilder.toString()));
                break;
            case "publishYear":
                inputBook.setPublishYear(Integer.parseInt(stringBuilder.toString()));
                break;
            case "totalPages":
                inputBook.setTotalPages(Integer.parseInt(stringBuilder.toString()));
                break;
            case "genre":
                if (BookGenre.hasValue(stringBuilder.toString())) {
                    inputBook.setBookGenre(BookGenre.setBookGenre(stringBuilder.toString()));
                } else {
                    inputBook.setBookGenre(null);
                }
                break;
            case "book":
                stackOfTagsName.pop();
                try {
                    Book book = valueOfBook(inputBook.getBookFamily(), inputBook);
                    books.add(book);
                }catch (CustomExceptions e){
                    System.out.println(e.getMessage());
                    break;
                }
                break;
        }
        stringBuilder.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data.trim());
    }

}
