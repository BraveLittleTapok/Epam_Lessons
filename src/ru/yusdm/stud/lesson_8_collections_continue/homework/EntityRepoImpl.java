package ru.yusdm.stud.lesson_8_collections_continue.homework;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.storage.IdGenerator;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Dinara Shabanova on 02.09.2019.
 */
public class EntityRepoImpl<T> implements EntityRepo {


    @Override
    public Long add(Entity element, List listToAdd) {
       element.setId(IdGenerator.generateId());
        listToAdd.add(element);
        return element.getId();
    }

    @Override
    public void delete(Entity element, List listToAdd) {
        Iterator<Entity> iter = listToAdd.iterator();
        while (iter.hasNext()) {
            boolean idsMatches = element.getId().equals(iter.next().getId());
            if (idsMatches) {
                iter.remove();
                break;
            }
        }
    }

    @Override
    public void print(List list) {
        for (Object element : list) {
            if (element != null) {
                System.out.println(element.toString());
            }
        }
    }
}
//    public static void removeAuthor(Author author) {
//    Iterator<Author> authors = CollectionStorage.authors.iterator();
//        while (authors.hasNext()) {
//                boolean idsMatches = authors.next().getId().equals(author.getId());
//                if (idsMatches) {
//                authors.remove();
//                break;
//                }
//                }