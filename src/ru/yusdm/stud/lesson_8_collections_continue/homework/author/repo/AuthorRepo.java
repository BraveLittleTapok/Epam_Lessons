package src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.BaseRepo;

import java.util.List;

public interface AuthorRepo extends BaseRepo<Author, Long> {
    public List<Author> getAllAuthors();
}
