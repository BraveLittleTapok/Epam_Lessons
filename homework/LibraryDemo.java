package ru.yusdm.stud.lesson_4_oop_continue.homework;

public class LibraryDemo {

    public static void main(String[] args) {
        Library library = new Library();
        initData(library);

    //    library.printAuthors();
     //   library.printBooks();
        library.printAllBooksWithAuthors();
        System.out.println();
    }

    private static void initData(Library library) {
        InputBook inputBook1 = new InputBook();
        inputBook1.setName("Zolotaya rybka");
        inputBook1.setGenreOfBook(GenreOfBook.FAIRY_TALE);
        inputBook1.setPublishYear(11);
        Book book1 = valueOf(inputBook1);

        InputBook inputBook2 = new InputBook();
        inputBook2.setName("Rusla and Ludmila");
        inputBook2.setGenreOfBook(GenreOfBook.POEM);
        inputBook2.setPublishYear(11);
        Book book2 = valueOf(inputBook2);

        InputBook inputBook3 = new InputBook();
        inputBook3.setName("Print book");
        inputBook3.setGenreOfBook(GenreOfBook.FANTASY);
        inputBook3.setPublishYear(2000);
        Book book3 = valueOf(inputBook3);

        InputBook inputBook4 = new InputBook();
        inputBook4.setName("HANDMADED_book");
        inputBook4.setTypeOfBook(TypeOfBook.HANDWRITTEN);
        inputBook4.setGenreOfBook(GenreOfBook.ENCYCLOPEDIA);
        inputBook4.setPublishYear(2000);
        Book book4 = valueOf(inputBook4);

        InputAuthor inputAuthor1 = new InputAuthor();
        inputAuthor1.setLastName("Pushkin");
        inputAuthor1.setYearOfBorn(22);
        Author author1 = valueOf(inputAuthor1);
        author1.setBooks(new Book[]{book1, book2});

        InputAuthor inputAuthor2 = new InputAuthor();
        inputAuthor2.setName("Vasya");
        inputAuthor2.setLastName("Ivanov");
        inputAuthor2.setYearOfBorn(22);
        Author author2 = valueOf(inputAuthor2);
        author2.setBooks(new Book[]{book1, book2, book3});

        InputAuthor inputAuthor3 = new InputAuthor();
        inputAuthor3.setLastName("Rukopis");
        inputAuthor3.setYearOfBorn(22);
        Author author3 = valueOf(inputAuthor3);
        author3.setBooks(new Book[]{book4});

        book1.setAuthors(new Author[]{author1});
        book2.setAuthors(new Author[]{author1});
        book3.setAuthors(new Author[]{author2});
        book4.setAuthors(new Author[]{author1, author3});

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        library.addAuthor(author1);
        library.addAuthor(author2);
        library.addAuthor(author3);
    }

    private static Book valueOf(InputBook inputBook) {
        Book book = new Book();
        book.setName(inputBook.getName());
        book.setPublishYear(inputBook.getPublishYear());
        book.setGenreOfBook(inputBook.getGenreOfBook());
        book.setTypeOfBook(inputBook.getTypeOfBook());
        return book;
    }

    private static Author valueOf(InputAuthor inputAuthor) {
        Author author = new Author(null);
        author.setName(inputAuthor.getName());
        author.setLastName(inputAuthor.getLastName());
        return author;
    }
}
