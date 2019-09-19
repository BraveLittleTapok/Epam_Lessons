package ru.yusdm.stud.lesson_8_collections_continue.homework;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookServiceImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.BasicDataInitializer;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerFactory;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServiceInitializer;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType.*;
import static ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType.COLLECTION;

public class LibraryDemo {

    public static void main(String[] args) throws Exception {
        try {
            StorageType storageType = COLLECTION;
            DataInitializerType dataInitializerType = FROM_XML_DOM_PARSER;

            ServicesHolder servicesHolder = new ServiceInitializer().initServices(storageType);
            BasicDataInitializer dataInitializer = DataInitializerFactory.getDataInitializer(dataInitializerType, servicesHolder);
            dataInitializer.initData();

            BookService bookService = servicesHolder.getBookService();
            AuthorService authorService = servicesHolder.getAuthorService();

            bookService.print();
            authorService.print();
        /*    System.out.println("BOOKA: " +
                    ((BookServiceImpl)bookService).findBookByLambda(book -> book.getPublishYear() == 2000));*/

            List<Book> booksCopy = new ArrayList(bookService.getAllBooks());
            Collections.sort(booksCopy, Comparator.comparing(Book::getName));

            booksCopy.stream()
                    .map(book -> book.getName())
                    .forEach(System.out::println);
      /*     Path tempFile = Files.createTempFile("my-file", ".txt");

            LibraryExportData lib = new LibraryExportData();
            String path = tempFile.toAbsolutePath().toString();
            lib.exportAll(path , servicesHolder);

            System.out.println("EXPORT FILE IS " + path);*/
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
