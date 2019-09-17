package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.BookGenre;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.BadBookTypeException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.author.InputAuthor;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class ParseStringsFromInputEntity {

    static InputAuthor getParseInputAuthor(List<String> listOfStrings) {
        List<String> nameOfAuthor = new ArrayList<>(Arrays.asList(listOfStrings.get(0).split(" ")));
        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setName(nameOfAuthor.get(0));
        inputAuthor.setLastName(nameOfAuthor.get(1));
        String strTrim = listOfStrings.get(1).trim();
        inputAuthor.setYearOfBorn(Integer.parseInt(strTrim));
        return inputAuthor;
    }

    static InputBook getParseInputBook(List<String> listOfStrings) throws CustomException {
        InputBook inputBook = new InputBook();
        inputBook.setName(listOfStrings.get(2));
        String strTrim = listOfStrings.get(3).trim();
        inputBook.setPublishYear(Integer.parseInt(strTrim));
        strTrim = listOfStrings.get(4).trim();
        inputBook.setTotalPages(Integer.parseInt(strTrim));
        inputBook.setBookFamily(getParseBookFamily(listOfStrings.get(6)));
        strTrim = listOfStrings.get(5).trim();
        if (BookGenre.hasValue(strTrim)) {
            inputBook.setBookGenre(BookGenre.setBookGenre(strTrim));
            return inputBook;
        } else {
            throw new BadBookTypeException("Bad Genre of the Book", inputBook.getName());
        }
    }

    private static String getParseBookFamily(String s) {
        if (s.contains("Printed")) {
            return "Printed";
        } else if (s.contains("Hand")) {
            return "Hand";
        } else {
            return null;
        }
    }
}
