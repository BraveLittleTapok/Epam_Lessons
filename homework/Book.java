package ru.yusdm.stud.lesson_4_oop_continue.homework;

public class Book {

    private Long id;
    private String name;
    private int publishYear;
    private int totalPages;
    private Author[] authors;
    private TypeOfBook typeOfBook;

    private GenreOfBook genreOfBook;

    public GenreOfBook getGenreOfBook() {
        return genreOfBook;
    }

    public void setGenreOfBook(GenreOfBook genreOfBook) {
        this.genreOfBook = genreOfBook;
    }

    public TypeOfBook getTypeOfBook() {
        return typeOfBook;
    }

    public void setTypeOfBook(TypeOfBook typeOfBook) {
        this.typeOfBook = typeOfBook;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public void setAuthors(Author[] authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", publishYear=" + publishYear +
                ", totalPages=" + totalPages +
                '}';
    }
}
