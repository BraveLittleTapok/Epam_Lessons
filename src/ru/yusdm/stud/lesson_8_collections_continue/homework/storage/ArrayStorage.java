package ru.yusdm.stud.lesson_8_collections_continue.homework.storage;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;

public final class ArrayStorage {
    private static final int CAPACITY = 10;

    private static Book[] books = new Book[CAPACITY];
    private static int bookIndex = 0;

    private static Author[] authors = new Author[CAPACITY];
    private static int authorIndex = 0;


    private ArrayStorage() {
    }

    //-----------Books---------------------------------------------------------
    public static Book[] getAllBooks() {
        return books;
    }

    public static int getTotalBooks() {
        return bookIndex;
    }

    public static void addBook(Book book) {
        book.setId(IdGenerator.generateId());
        if (bookIndex % (CAPACITY) == 0 && bookIndex != 0) {
            increaseBooksStorage();
        } else {
            books[bookIndex] = book;
        }
        bookIndex++;
    }

    private static void increaseBooksStorage() {
        Book[] books = new Book[authorIndex + CAPACITY];

        for (int i = 0; i < books.length; i++) {
            books[i] = ArrayStorage.books[i];
        }

        ArrayStorage.books = books;
    }

    public static void removeBook(Book book) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < books.length; i++) {

            if (book.getId().equals(books[i].getId())) {
                books[i] = null;
                bookIndex--;
                break;
            }

        }
        /**
         *  [0] = A
         *  [1] = NULL
         *  [2] = C
         *  [3] = NULL
         */

        Book[] newBooks = new Book[books.length];
        int index = 0;
        for (Book b : books) {
            if (b != null) {
                newBooks[index] = b;
                index++;
            }
        }

        /**
         *  [0] = A
         *  [1] = C
         *  [2] = NULL
         *  [3] = NULL
         */
        books = newBooks;
    }


    //-----------Authors---------------------------------------------------------
    public static Author[] getAllAuthors() {
        return authors;
    }

    public static int getTotalAuthors() {
        return authorIndex;
    }

    public static void addAuthor(Author author) {
        author.setId(IdGenerator.generateId());

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        } else {
            authors[authorIndex] = author;
        }

        authorIndex++;
    }

    private static void increaseAuthorsStorage() {
        Author[] authors = new Author[authorIndex + CAPACITY];

        for (int i = 0; i < authors.length; i++) {
            authors[i] = ArrayStorage.authors[i];
        }

        ArrayStorage.authors = authors;
    }

    public static void removeAuthor(Author author) {
        /**
         *  [0] = A
         *  [1] = B
         *  [2] = C
         *  [3] = NULL
         */
        for (int i = 0; i < authors.length; i++) {

            if (author.getId().equals(authors[i].getId())) {
                authors[i] = null;
                authorIndex--;
                break;
            }

        }
        /**
         *  [0] = A
         *  [1] = NULL
         *  [2] = C
         *  [3] = NULL
         */

        Author[] newAuthors = new Author[ArrayStorage.authors.length];
        int index = 0;
        for (Author a : authors) {
            if (a != null) {
                newAuthors[index] = a;
                index++;
            }
        }

        /**
         *  [0] = A
         *  [1] = C
         *  [2] = NULL
         *  [3] = NULL
         */
        authors = newAuthors;
    }

}
