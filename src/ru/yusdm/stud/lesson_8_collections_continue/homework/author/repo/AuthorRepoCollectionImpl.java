package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;
import ru.yusdm.stud.lesson_8_collections_continue.homework.*;

public class AuthorRepoCollectionImpl implements AuthorRepo {
    final EntityRepo entity = new EntityRepoImpl();

    @Override
    public int count() {
        return CollectionStorage.getTotalAuthors();
    }

    @Override
    public void print() {
        entity.print(CollectionStorage.getAllAuthors());
    }

    @Override
    public void delete(Author author) {
        entity.delete(author, CollectionStorage.getAllAuthors());
    }

    @Override
    public Long add(Author author) {
        return entity.add(author, CollectionStorage.getAllAuthors());
    }
}
