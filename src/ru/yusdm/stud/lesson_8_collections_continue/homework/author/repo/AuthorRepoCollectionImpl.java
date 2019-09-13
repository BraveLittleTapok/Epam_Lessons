package src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;

import java.util.List;

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
    public Author findById(Long authorId) {
        for (Author author : CollectionStorage.getAllAuthors()) {
            if (author != null && authorId.equals(author.getId())) {
                return author;
            }
        }

        return null;
    }
}
