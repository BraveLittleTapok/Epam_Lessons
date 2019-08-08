package ru.yusdm.stud.lesson_4_oop_continue.homework;

/**
 * Created by Dinara Shabanova on 08.08.2019.
 */
public enum TypeOfBook {
    PRINT("Printed book"),
    HANDWRITTEN("WARNING! This book is hand written");

    private final String descriptionTypeOfBook;

    TypeOfBook(String descriptionTpeOfBook) {
        this.descriptionTypeOfBook = descriptionTpeOfBook;
    }

    public String getDescriptionTypeOfBook() {
        return descriptionTypeOfBook;
    }
}
