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


  /*  public static void addBook(Book book) {
        book.setId(IdGenerator.generateId());
        books.add(book);
    }*/

/*    public static void removeBook(Book book) {
        Iterator<Book> booksIter = books.iterator();
        while (booksIter.hasNext()) {
            boolean idsMatches = booksIter.next().getId().equals(book.getId());
            if (idsMatches) {
                booksIter.remove();
                break;
            }
        }
    }*/

    //-----------Authors---------------------------------------------------------
    public static List<Author> getAllAuthors() {
        return authors;
    }

    public static int getTotalAuthors() {
        return authors.size();
    }

   /* public static void addAuthor(Author author) {
        author.setId(IdGenerator.generateId());
        authors.add(author);
    }

  /*  public static void removeAuthor(Author author) {
        Iterator<Author> authors = CollectionStorage.authors.iterator();
        while (authors.hasNext()) {
            boolean idsMatches = authors.next().getId().equals(author.getId());
            if (idsMatches) {
                authors.remove();
                break;
            }
        }
    }*/

   /* public static<T extends Entity> Long add(T element, List<T> listToAdd) {
        element.setId(IdGenerator.generateId());
        listToAdd.add(element);
        return element.getId();
    }*/
}
