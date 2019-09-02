package ru.yusdm.stud.lesson_8_collections_continue.homework.author.service;

import ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo.*;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.*;

public interface AuthorService extends BaseRepo<Author> {
    int count();
   /* void print();
    void delete(Author author);
    Long add(Author author);*/
    void deleteBooksWhichOldAndSentReport();
}
