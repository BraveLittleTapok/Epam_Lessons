package ru.yusdm.stud.lesson_4_oop_continue.homework;

public class Storage {
    public static final int CAPACITY = 1;
    public static Book[] books = new Book[CAPACITY];
    public static int bookIndex = 0;

    public static void increaseBookIndex() {
        bookIndex++;
    }

    public static Author[] authors = new Author[CAPACITY];
    public static int authorIndex = 0;

    public static void increaseAuthorIndex() {
        authorIndex++;
    }


    public static void addAuthor(Author author) {
        author.setId(System.currentTimeMillis());

        if (authorIndex % (CAPACITY) == 0 && authorIndex != 0) {
            increaseAuthorsStorage();
        }
        authors[authorIndex] = author;
        Storage.increaseAuthorIndex();
    }

    public static void addBook(Book book) {
        book.setId(System.currentTimeMillis());

        if (bookIndex % (CAPACITY) == 0 && bookIndex != 0) {
            increaseBookStorage();
        }
        books[bookIndex] = book;
        Storage.increaseBookIndex();
    }

    public static void increaseAuthorsStorage() {

        Author[] authors = new Author[authorIndex + CAPACITY];
        System.arraycopy(Storage.authors, 0, authors, 0, Storage.authors.length);
        Storage.authors = authors;
    }

    public static void increaseBookStorage() {
        Book[] book = new Book[bookIndex + CAPACITY];
        System.arraycopy(Storage.books, 0, book, 0, books.length);
        Storage.books = book;
    }
}
