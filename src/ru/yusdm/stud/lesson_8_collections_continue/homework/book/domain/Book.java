package src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.domain.BaseDomain;

import java.util.List;

public class Book extends BaseDomain<Long> {
    protected String name;
    protected int publishYear;
    protected int totalPages;
    protected List<Author> authors;
    protected BookGenre bookType;

    public BookGenre getBookGenre() {
        return bookType;
    }

    public void setBookGenre(BookGenre bookType) {
        this.bookType = bookType;
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

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
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

    public void deleteAuthor(Author author) {

    }

    public boolean withoutAuthors() {

        return false;
    }
}
