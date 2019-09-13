package src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.repo;

public interface BaseRepo<T, ID> {
    int count();

    void print();

    void delete(T t);

    ID add(T t);

    T findById(ID id);
}
