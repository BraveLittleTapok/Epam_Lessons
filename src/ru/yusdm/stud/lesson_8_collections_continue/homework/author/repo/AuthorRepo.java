package ru.yusdm.stud.lesson_8_collections_continue.homework.author.repo;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.*;

public interface AuthorRepo extends BaseRepo<Author>{
    int count();
  /*  void print();
    void delete(Author author);
    Long add(Author author);*/
}
