package ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain;

import java.util.HashMap;
import java.util.Map;

public enum BookGenre {
    SCIENCE, NOVEL;

    static Map<String, BookGenre> colorsMap = new HashMap<>();

    static {
        for (BookGenre color : BookGenre.values()) {
            colorsMap.put(color.name(), color);
        }
    }

    public static boolean hasValue(String valueStr) {
        return colorsMap.containsKey(valueStr);
    }

    public static BookGenre setBookGenre(String string){
        return colorsMap.get(string);
    }
}
