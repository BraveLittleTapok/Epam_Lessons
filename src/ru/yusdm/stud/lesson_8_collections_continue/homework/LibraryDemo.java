package src.ru.yusdm.stud.lesson_8_collections_continue.homework;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookService;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.LibraryExportData;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.BadBookTypeException;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.BasicDataInitializer;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerFactory;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServiceInitializer;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType;

import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType.FROM_TXT_FILE;
import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer.DataInitializerType.FROM_XML;
import static src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType.COLLECTION;

public class LibraryDemo {

    public static void main(String[] args) throws Exception {
        try {
            StorageType storageType = COLLECTION;
            DataInitializerType dataInitializerType = FROM_TXT_FILE;

            ServicesHolder servicesHolder = new ServiceInitializer().initServices(storageType);
            BasicDataInitializer dataInitializer = DataInitializerFactory.getDataInititalizer(dataInitializerType, servicesHolder);
            try {
                dataInitializer.initData();
            }catch (BadBookTypeException e) {
                System.out.print(e.getMessage() + ": ");
                System.out.println(e.getNameOfBook());
            }

            BookService bookService = servicesHolder.getBookService();
            AuthorService authorService = servicesHolder.getAuthorService();

            bookService.print();
            authorService.print();
        /*    String path = "C:\\Users\\DS\\Desktop\\export.txt";
            LibraryExportData lib = new LibraryExportData();
            lib.exportAll(path, servicesHolder);*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
