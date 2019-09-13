package src.ru.yusdm.stud.lesson_8_collections_continue.homework;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer.BasicDataInitializer;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer.DataInitializerFactory;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer.DataInitializerType;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.serviceinitializer.ServiceInitializer;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.serviceinitializer.ServicesHolder;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType;

import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer.DataInitializerType.FROM_TXT_FILE;
import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType.COLLECTION;

public class LibraryDemo {

    public static void main(String[] args) {
        try {
            StorageType storageType = COLLECTION;
            DataInitializerType dataInitializerType = FROM_TXT_FILE;

            ServicesHolder servicesHolder = new ServiceInitializer().initServices(storageType);
            BasicDataInitializer dataInitializer = DataInitializerFactory.getDataInititalizer(dataInitializerType, servicesHolder);

            dataInitializer.initData();

            BookService bookService = servicesHolder.getBookService();
            AuthorService authorService = servicesHolder.getAuthorService();

            bookService.print();
            authorService.print();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
