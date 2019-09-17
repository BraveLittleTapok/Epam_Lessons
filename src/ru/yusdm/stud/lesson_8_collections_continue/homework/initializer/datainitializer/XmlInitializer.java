package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.FileUtils;
import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

/**
 * Created by Тапок on 15.09.2019.
 */
public class XmlInitializer extends BasicDataInitializer {
    private static final String PATH =
            "/ru/yusdm/stud/lesson_8_collections_continue/homework/initializer/datainitializer/DataOfLibrary.xml";

    public XmlInitializer(ServicesHolder servicesHolder) {
        super(servicesHolder);
    }

    @Override
    public void initData() throws Exception {
        File xmlFile = FileUtils.createFileFromResource("xml", "33", PATH);

        SAXParserFactory factory = SAXParserFactory.newInstance();

        SAXParser saxParser = factory.newSAXParser();
        SAXEventHandler saxHandler = new SAXEventHandler(servicesHolder);
        saxParser.parse(xmlFile, saxHandler);
    }

}
