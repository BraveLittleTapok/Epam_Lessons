package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.BaseRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.CollectionStorage;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.IdGenerator;

import java.util.Iterator;

public class AuthorRepoCollectionImpl implements AuthorRepo, BaseRepo<Author> {

    @Override
    public int count() {
        return CollectionStorage.getTotalAuthors();
    }

    @Override
    public void print() {
        for (Object element : CollectionStorage.getAllAuthors()) {
            if (element != null) {
                System.out.println(element.toString());
            }
        }
    }

    @Override
    public void delete(Author author) {
        Iterator<Author> iter = CollectionStorage.getAllAuthors().iterator();
        while (iter.hasNext()) {
            boolean idsMatches = author.getId().equals(iter.next().getId());
            if (idsMatches) {
                iter.remove();
                break;
            }
        }
    }

    @Override
    public Long add(Author author) {
        author.setId(IdGenerator.generateId());
        CollectionStorage.getAllAuthors().add(author);
        return author.getId();
    }
}
