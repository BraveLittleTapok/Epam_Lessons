package src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class BadBookTypeException extends CustomExceptions {
    private String nameOfBook;

    public String getNameOfBook() {
        return nameOfBook;
    }

    public BadBookTypeException(String message, String nameOfBook) {
        super(message);
        this.nameOfBook = nameOfBook;
    }
}