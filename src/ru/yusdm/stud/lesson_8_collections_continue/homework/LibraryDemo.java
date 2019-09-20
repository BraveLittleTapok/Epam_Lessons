package ru.yusdm.stud.lesson_8_collections_continue.homework;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
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

import static ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType.FROM_XML_DOM_PARSER;
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
            //------------------------------------LAMBDA---------------------------------------------------------

            System.out.println("Search1: ");
            List<Book> booksFind =
                    ((BookServiceImpl)bookService).findBookByLambda(book -> book.getPublishYear() == 2000);

            System.out.println(booksFind.toString());


            System.out.println("Search2: ");
            booksFind = ((BookServiceImpl) bookService)
                    .findBookByLambda(book -> book.getName().equalsIgnoreCase("gold fish"));
            booksFind.stream()
                    .map(book -> book.toString())
                    .forEach(System.out::println);

            System.out.println("Sort: ");
            List<Book> booksCopy = new ArrayList(bookService.getAllBooks());
            Collections.sort(booksCopy, Comparator.comparing(Book::getName));
            booksCopy.stream()
                    .map(book -> book.getName())
                    .forEach(System.out::println);
            //------------------------------------LAMBDA---------------------------------------------------------
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
