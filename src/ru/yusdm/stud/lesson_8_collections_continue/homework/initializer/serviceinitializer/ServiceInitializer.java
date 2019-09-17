package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoArrayImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoCollectionImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorServiceImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoArrayImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoCollectionImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookServiceImpl;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public final class ServiceInitializer {
    private BookRepo bookRepo;
    private AuthorRepo authorRepo;

    public ServicesHolder initServices(StorageType storageType) {
        initRepos(storageType);
        return new ServicesHolder(
                new BookServiceImpl(bookRepo),
                new AuthorServiceImpl(authorRepo, bookRepo)
        );
    }

    private void initRepos(StorageType storageType) {
        switch (storageType) {
            case ARRAY: {
                bookRepo = new BookRepoArrayImpl();
                authorRepo = new AuthorRepoArrayImpl();
                break;
            }

            case COLLECTION: {
                bookRepo = new BookRepoCollectionImpl();
                authorRepo = new AuthorRepoCollectionImpl();
                break;
            }
        }
    }

}
