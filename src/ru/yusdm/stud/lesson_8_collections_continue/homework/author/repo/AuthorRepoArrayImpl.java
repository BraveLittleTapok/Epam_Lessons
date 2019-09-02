package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.*;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.ArrayStorage;

public class AuthorRepoArrayImpl implements AuthorRepo, BaseRepo<Author> {
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

}
