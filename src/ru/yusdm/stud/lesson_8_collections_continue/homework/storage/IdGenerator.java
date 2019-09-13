package src.ru.yusdm.stud.lesson_8_collections_continue.homework.storage;

public final class IdGenerator {
    public static long id = 1;

    private IdGenerator() {

    }

    public static Long generateId() {
        return id++;
    }
}
