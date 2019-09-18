package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import java.io.File;
import java.util.List;

/**
 * Created by Dinara Shabanova on 18.09.2019.
 */
public class DomXmlDataInitializer extends BasicDataInitializer  {
    private static final String PATH =
            "/ru/yusdm/stud/lesson_8_collections_continue/homework/initializer/datainitializer/DataOfLibrary.xml";

    public DomXmlDataInitializer(ServicesHolder servicesHolder) throws Exception {
        super(servicesHolder);
    }
    @Override
    public List<Author> getParsedData() throws Exception {
        List<Author> authors;
        File xmlFile = FileUtils.createFileFromResource("xml", "33", PATH);
        if (isFileValid(xmlFile)) {
            DomParser parser = new DomParser();
            authors = parser.DomParserAuthors(xmlFile);
        } else {
            throw new IllegalArgumentException("Bad file");
        }
        return authors;
    }
}
