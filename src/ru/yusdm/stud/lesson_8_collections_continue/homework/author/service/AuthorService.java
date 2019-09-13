package src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.service;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.service.BaseService;

import java.util.List;

public interface AuthorService extends BaseService<Author, Long> {
    void deleteBooksWhichOldAndSentReport();
    List<Author> getAllAuthors();
}
