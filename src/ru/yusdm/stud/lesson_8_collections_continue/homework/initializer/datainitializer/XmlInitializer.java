package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.File;
import java.util.List;

import static ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils.mutableListOf;

/**
 * Created by Тапок on 15.09.2019.
 */
public class XmlInitializer extends BasicDataInitializer {
    private static final String PATH =
            "/ru/yusdm/stud/lesson_8_collections_continue/homework/initializer/datainitializer/DataOfLibrary.xml";
    private DataInitializerType dataInitializerType;

    public XmlInitializer(ServicesHolder servicesHolder, DataInitializerType dataInitializerType) {
        super(servicesHolder);
        this.dataInitializerType = dataInitializerType;
    }

    @Override
    public void initData() throws Exception {
        File xmlFile = FileUtils.createFileFromResource("xml", "33", PATH);
        if (isFileValid(xmlFile)) {
            ParseFromXML handler = new ParseFromXML(xmlFile, dataInitializerType);
            addToLibrary(handler.getAuthorsWithBooks());
        } else {
            throw new IllegalArgumentException("Bad file");
        }
    }

    private boolean isFileValid(File file) {
        return file != null && file.isFile() && file.exists();
    }

    private void addToLibrary(List<Author> authors) {
        AuthorService authorService = servicesHolder.getAuthorService();
        BookService bookService = servicesHolder.getBookService();

        for (Author author : authors) {
            authorService.add(author);
            for (Book bookToAdd : author.getBooks()) {
                bookToAdd.setAuthors(mutableListOf(author));
                if (bookService.count() == 0) { //if storage is empty
                    bookService.add(bookToAdd);
                } else {
                    boolean newBookAddedInLibrary = false;
                    for (Book bookAlreadyInStorage : bookService.getAllBooks()) {  //if book has several authors
                        if (bookToAdd.getName().equalsIgnoreCase(bookAlreadyInStorage.getName())) {
                            updateListOfAuthorsForBook(bookAlreadyInStorage, author);
                            newBookAddedInLibrary = true;
                        }
                    }
                    if (!newBookAddedInLibrary) {
                        bookService.add(bookToAdd);
                    }
                }
            }
        }
    }
}
