package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;

/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public final class DataInitializerFactory {
    private DataInitializerFactory() {

    }

    public static BasicDataInitializer getDataInitializer(DataInitializerType dataInitializerType, ServicesHolder servicesHolder) throws Exception {
        switch (dataInitializerType) {
            case IN_MEMORY: {
                return new InMemoryInitializer(servicesHolder);
            }
            case FROM_TXT_FILE: {
                return new FileInitializer(servicesHolder);
            }
            case FROM_XML_SAX_PARSER: {
                return new DomXmlDataInitializer(servicesHolder);
            }
            case FROM_XML_DOM_PARSER: {
                return new SaxXmlDataInitializer(servicesHolder);
            }
            default: {
                throw new RuntimeException("Unknown initializer for '" + dataInitializerType + "'");
            }
        }
    }
}
