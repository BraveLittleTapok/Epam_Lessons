package src.ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepo;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoArrayImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo.AuthorRepoCollectionImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service.AuthorServiceImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepo;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoArrayImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.repo.BookRepoCollectionImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.service.BookServiceImpl;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage.StorageType;

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
