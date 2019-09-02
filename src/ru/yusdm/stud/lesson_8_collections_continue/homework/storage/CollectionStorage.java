package ru.yusdm.stud.lesson_8_collections_continue.homework.storage;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;

import java.util.ArrayList;
import java.util.List;

public final class CollectionStorage {
    private static List<Book> books = new ArrayList<>();
    private static List<Author> authors = new ArrayList<>();

    private CollectionStorage() {
    }

    //-----------Books---------------------------------------------------------
    public static List<Book> getAllBooks() {
        return books;
    }

    public static int getTotalBooks() {
        return books.size();
    }


    //-----------Authors---------------------------------------------------------
    public static List<Author> getAllAuthors() {
        return authors;
    }

    public static int getTotalAuthors() {
        return authors.size();
    }

}
