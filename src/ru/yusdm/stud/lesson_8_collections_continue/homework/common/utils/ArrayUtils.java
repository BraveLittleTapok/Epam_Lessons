package src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils;

public final class ArrayUtils {
    private ArrayUtils() {
    }

    public static <T> void copyNotNullElements(T[] src, T[] dest) {
        int index = 0;

        for (T t : src) {
            if (t != null) {
                dest[index] = t;
                index++;
            }
        }
    }

    public static <T> void copyElements(T[] src, T[] dest) {
        int index = 0;

        for (T t : src) {
            dest[index] = t;
            index++;
        }
    }
}
