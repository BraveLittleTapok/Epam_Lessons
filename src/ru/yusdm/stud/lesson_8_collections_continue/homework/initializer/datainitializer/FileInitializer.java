package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.book.domain.Book;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import ru.yusdm.stud.lesson_8_collections_continue.homework.exceptions.CustomException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.book.InputBook;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.CollectionUtils.mutableListOf;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 * type of file
 * /* Author name lastname | Date of birth | Name of BOOK | publishYear | totalPages | BookGenre | BookType|
 * [0]                     [1]             [2]             [3]         [4]         [5]            [7]   => size = 7
 */
public class FileInitializer extends BasicDataInitializer {

    private static final String PATH = "/ru/yusdm/stud/lesson_8_collections_continue/homework/initializer/datainitializer/DataLibrary.txt";

    public FileInitializer(ServicesHolder servicesHolder) throws Exception {
        super(servicesHolder);
    }

    @Override
    public List<Author> getParsedData() throws IOException, CustomException {
        File fileWithInitData = FileUtils.createFileFromResource("java_core", "any", PATH);
        List<String> data = Files.readAllLines(Paths.get(fileWithInitData.getAbsolutePath()));
        return parseFile(data);
    }

    private List<Author> parseFile(List<String> stringsFromFile) throws CustomException {
        List<Author> authors = new ArrayList<>();
        for (String str : stringsFromFile) {
            if (!str.contains("/*")) {
                //Split by |
                List<String> listOfStrings = new ArrayList<>(Arrays.asList(str.split("\\|")));
                deleteSplittedCharacter(listOfStrings);
                if (listOfStrings.size() == 7) {
                    Author newAuthor = valueOfInputAuthor(ParseStringsFromInputEntity.getParseInputAuthor(listOfStrings));
                    Book newBook = valueOfInputBook(ParseStringsFromInputEntity.getParseInputBook(listOfStrings));
                    if (authors.size() == 0) {
                        newAuthor.setBooks(mutableListOf(newBook));
                        authors.add(newAuthor);
                    } else {
                        boolean authorIsAlreadyExist = false;
                        for (Author authorAlreadyExist : authors) {
                            if (newAuthor.getLastName().equals(authorAlreadyExist.getLastName())) {
                                authorIsAlreadyExist = true;
                                updateListOfBooksForAuthor(authorAlreadyExist, newBook);
                            }
                        }
                        if (!authorIsAlreadyExist) {
                            newAuthor.setBooks(mutableListOf(newBook));
                            authors.add(newAuthor);
                        }
                    }
                } else {
                    throw new CustomException("Bad format file txt");
                }
            }
        }
        return authors;
    }

    private void deleteSplittedCharacter(List<String> listOfStrings) {
        Iterator<String> iter = listOfStrings.iterator();
        while (iter.hasNext()) {
            if (iter.next().contains("|")) {
                iter.remove();
            }
        }
    }

    private Book valueOfInputBook(InputBook inputBook) throws CustomException {
        return valueOfBook(inputBook.getBookFamily(), inputBook);
    }

}
