package ru.yusdm.stud.lesson_8_collections_continue.homework.common;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorService;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.FileOutputStream;
import java.io.PrintWriter;

/**
 * Created by Тапок on 15.09.2019.
 */
public class LibraryExportData {

    public void exportAll(String path, ServicesHolder servicesHolder) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(path))) {
            AuthorService authorService = servicesHolder.getAuthorService();
            for (Author author : authorService.getAllAuthors()) {
                StringBuilder string = new StringBuilder();
                string.append("Author: " + author.getName() + " " + author.getLastName());
                if (author.getBooks().size() == 1) {
                    string.append(" Book: " + author.getBooks().get(0).getName());
                } else {
                    string.append(" Books: ");
                    for (Book book : author.getBooks()) {
                        string.append(book.getName() + "; ");
                    }
                }
                writer.println(string);
            }
        } catch (Exception e) {
            System.out.println("Something wroung with output file");
            e.printStackTrace();
        }
    }
}
