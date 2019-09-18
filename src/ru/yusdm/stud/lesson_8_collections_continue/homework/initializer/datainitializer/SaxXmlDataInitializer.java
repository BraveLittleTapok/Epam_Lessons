package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import org.xml.sax.SAXException;
import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;
import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Dinara Shabanova on 18.09.2019.
 */
public class SaxXmlDataInitializer extends BasicDataInitializer {
    private static final String PATH =
            "/ru/yusdm/stud/lesson_8_collections_continue/homework/initializer/datainitializer/DataOfLibrary.xml";

    public SaxXmlDataInitializer(ServicesHolder servicesHolder) throws Exception {
        super(servicesHolder);
    }

    @Override
    public List<Author> getParsedData() throws IOException, SAXException, ParserConfigurationException {
        List<Author> authors;
        File xmlFile = FileUtils.createFileFromResource("xml", "33", PATH);
        if (isFileValid(xmlFile)) {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            SAXEventHandler saxHandler = new SAXEventHandler();
            saxParser.parse(xmlFile, saxHandler);
            authors = saxHandler.getAuthors();
        } else {
            throw new IllegalArgumentException("Bad file");
        }
        return authors;
    }
}


