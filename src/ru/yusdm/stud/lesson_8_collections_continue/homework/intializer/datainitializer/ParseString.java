package src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.BookGenre;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.BadBookTypeException;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.author.InputAuthor;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.book.InputBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public class ParseString {

    static InputAuthor getParseInputAuthor(List<String> listOfStrings) {
        List<String> nameOfAuthor = new ArrayList<>(Arrays.asList(listOfStrings.get(0).split(" ")));
        InputAuthor inputAuthor = new InputAuthor();
        inputAuthor.setName(nameOfAuthor.get(0));
        inputAuthor.setLastName(nameOfAuthor.get(1));
        String strTrim = listOfStrings.get(1).trim();
        inputAuthor.setYearOfBorn(Integer.parseInt(strTrim));
        return inputAuthor;
    }

    static InputBook getParseInputBook(List<String> listOfStrings) throws Exception {
        InputBook inputBook = new InputBook();
        inputBook.setName(listOfStrings.get(2));
        String strTrim = listOfStrings.get(3).trim();
        inputBook.setPublishYear(Integer.parseInt(strTrim));
        strTrim = listOfStrings.get(4).trim();
        inputBook.setTotalPages(Integer.parseInt(strTrim));
        inputBook.setBookFamily(getParseBookFamily(listOfStrings.get(6)));
        try {
            strTrim = listOfStrings.get(5).trim();
            if (BookGenre.hasValue(strTrim)) {
                inputBook.setBookGenre(BookGenre.setBookGenre(strTrim));
            } else {
                throw new BadBookTypeException("Bad Genre of the Book", inputBook.getName());
            }
        } catch (BadBookTypeException e) {
            System.out.print(e.getMessage() + ": ");
            System.out.println(e.getNameOfBook());
        } finally {
            return inputBook;
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
