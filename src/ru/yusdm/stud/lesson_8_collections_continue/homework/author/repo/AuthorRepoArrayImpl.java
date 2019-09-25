package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.ArrayStorage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AuthorRepoArrayImpl implements AuthorRepo {
    @Override
    public List<Author> getAllAuthors() {
        return new ArrayList<Author>(Arrays.asList(ArrayStorage.getAllAuthors()));
    }

    @Override
    public int count() {
        return ArrayStorage.getTotalAuthors();
    }

    @Override
    public void print() {
        for (Author author : ArrayStorage.getAllAuthors()) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        ArrayStorage.removeAuthor(author);
    }

    @Override
    public Long add(Author author) {
        ArrayStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public Author findById(Long authorId) {
        for (Author author : ArrayStorage.getAllAuthors()) {
            if (author != null && authorId.equals(author.getId())) {
                return author;
            }
        }

        return null;
    }

    @Override
    public List<Author> sort(List<Author> itemsToSort, Comparator<Author> comparator) {
        return null;
    }

}
