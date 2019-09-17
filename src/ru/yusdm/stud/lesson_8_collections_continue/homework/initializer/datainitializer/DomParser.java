package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.BookGenre;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.BadBookTypeException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinara Shabanova on 17.09.2019.
 */
public class DomParser {

    public List<Author> DomParserAuthors(File file) throws Exception {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            List<Author> authorsResult = new ArrayList<>();

            Node root = document.getElementsByTagName("authors").item(0);
            NodeList authors = ((Element) root).getElementsByTagName("author");
            for (int i = 0; i < authors.getLength(); i++) {
                Node authorNode = authors.item(i);
                Author author = new Author(null);

                NodeList authorInners = authorNode.getChildNodes();
                for (int j = 0; j < authorInners.getLength(); j++) {
                    Node authorInner = authorInners.item(j);

                    String nodeName = authorInner.getNodeName();
                    switch (nodeName) {
                        case "name":
                            author.setName(authorInner.getTextContent());
                            break;
                        case "lastName":
                            author.setLastName(authorInner.getTextContent());
                            break;
                        case "yearOfBirth":
                            author.setYearOfBorn(Integer.parseInt(authorInner.getTextContent()));
                            break;
                        case "books":
                            List<Book> booksForAuthor = new ArrayList<>();
                            NodeList books = ((Element) authorInner).getElementsByTagName("book");
                            for (int k = 0; k < books.getLength(); k++) {
                                Element bookXml = (Element) books.item(k);
                                InputBook inputBook = new InputBook();

                                String type = bookXml.getAttribute("type");
                                String name = bookXml.getElementsByTagName("name").item(0).getTextContent();
                                int publishYear = Integer.valueOf(bookXml.getElementsByTagName("publishYear").item(0).getTextContent());
                                int totalPages = Integer.valueOf(bookXml.getElementsByTagName("totalPages").item(0).getTextContent());
                                String genre = bookXml.getElementsByTagName("genre").item(0).getTextContent();

                                inputBook.setName(name);
                                inputBook.setTotalPages(totalPages);
                                inputBook.setPublishYear(publishYear);
                                inputBook.setFontFamily(type);
                                if (BookGenre.hasValue(genre)) {
                                    inputBook.setBookGenre(BookGenre.setBookGenre(genre));
                                } else {
                                    throw new BadBookTypeException("Bad Genre of the Book", inputBook.getName());
                                }
                                Book book = BasicDataInitializer.valueOfBook(type, inputBook);
                                booksForAuthor.add(book);
                            }
                            author.setBooks(booksForAuthor);
                            break;
                    }
                }
                authorsResult.add(author);
            }
            return authorsResult;

    }
}
