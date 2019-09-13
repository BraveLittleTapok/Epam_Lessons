package src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.domain.BaseDomain;

import java.util.List;

public class Author extends BaseDomain<Long> {

    private String lastName;
    private String name;
    private int yearOfBorn;
    private List<Book> books;

    public Author(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBorn() {
        return yearOfBorn;
    }

    public void setYearOfBorn(int yearOfBorn) {
        this.yearOfBorn = yearOfBorn;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", yearOfBorn=" + yearOfBorn +
                '}';
    }
}
