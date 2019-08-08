package ru.yusdm.stud.lesson_4_oop_continue.homework;

import static ru.yusdm.stud.lesson_4_oop_continue.homework.Storage.*;

public class Library {

    public void addAuthor(Author author) {
        Storage.addAuthor(author);
    }

    public void addBook(Book book) {
        Storage.addBook(book);
    }

    public void printBooks() {
        for (int i = 0; i < Storage.books.length; i++) {
            Book book = Storage.books[i];
            if (book != null) {
                System.out.println(getBookAsStr(book));
            }
        }
    }

    private String getBookAsStr(Book book) {
        return book.toString();
    }

    public void printAuthors() {
        for (int i = 0; i < authors.length; i++) {

            Author author = authors[i];
            if (author != null) {
                System.out.println(getAuthorAsStr(author));
            }

        }
    }

    private String getAuthorAsStr(Author author) {
        return author.toString();
    }

    public void printAllBooksWithAuthors() {
        for (int i = 0; i < Storage.books.length; i++) {
            System.out.printf("Book: %-20s", Storage.books[i].getName());
            System.out.printf("%-10s", " Author's: ");
            if (Storage.books[i] != null) {
                for (int j = 0; j < Storage.books[i].getAuthors().length; j++) {
                    Author author = Storage.books[i].getAuthors()[j];
                    System.out.printf("%-10s", author.getLastName());
                    if ((j+1)<Storage.books[i].getAuthors().length) {
                        System.out.print("and ");
                    }
                }
            }
            if (Storage.books[i].getTypeOfBook().equals(TypeOfBook.HANDWRITTEN)) {
                System.out.print(Storage.books[i].getTypeOfBook().getDescriptionTypeOfBook());
            }
            System.out.println();
        }

    }
}
