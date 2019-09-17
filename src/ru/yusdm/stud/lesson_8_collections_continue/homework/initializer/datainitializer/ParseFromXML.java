package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.author.domain.Author;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dinara Shabanova on 17.09.2019.
 */
public class ParseFromXML {
    private File fileXml;
    private DataInitializerType dataInitializerType;

    public ParseFromXML(File fileXml, DataInitializerType dataInitializerType) {
        this.fileXml = fileXml;
        this.dataInitializerType = dataInitializerType;
    }

    public List<Author> getAuthorsWithBooks() throws Exception {
        List<Author> authors = new ArrayList<>();
        switch (dataInitializerType) {
            case FROM_XML_SAX_PARSER: {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser saxParser = factory.newSAXParser();
                SAXEventHandler saxHandler = new SAXEventHandler();
                saxParser.parse(fileXml, saxHandler);
                authors = saxHandler.getAuthors();
                break;
            }
            case FROM_XML_DOM_PARSER: {
                DomParser parser = new DomParser();
                authors = parser.DomParserAuthors(fileXml);
           }
        }
        return authors;
    }
}
