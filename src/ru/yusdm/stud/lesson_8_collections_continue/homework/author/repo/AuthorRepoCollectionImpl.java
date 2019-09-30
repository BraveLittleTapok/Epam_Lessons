package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AuthorRepoCollectionImpl implements AuthorRepo {
    @Override
    public int count() {
        return CollectionStorage.getTotalAuthors();
    }

    @Override
    public List<Author> getAllAuthors() {
        return CollectionStorage.getAllAuthors();
    }

    @Override
    public void print() {
        for (Author author : CollectionStorage.getAllAuthors()) {
            if (author != null) {
                System.out.println(author.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        CollectionStorage.removeAuthor(author);
    }

    @Override
    public Long add(Author author) {
        CollectionStorage.addAuthor(author);
        return author.getId();
    }

    @Override
    public Optional<Author> findById(Long authorId) {
        for (Author author : CollectionStorage.getAllAuthors()) {
            if (authorId.equals(author.getId())) {
                return Optional.ofNullable(author);
            }
        }
        return null;
    }

    @Override
    public List<Author> sort(List<Author> itemsToSort, Comparator<Author> comparator) {
        return null;
    }
}
