package ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.datainitializer;

import ru.yusdm.stud.lesson_8_collections_continue.homework.initializer.serviceinitializer.ServicesHolder;
/**
 * Created by Dinara Shabanova on 12.09.2019.
 */
public final class DataInitializerFactory {
    private DataInitializerFactory() {

    }

    public static BasicDataInitializer getDataInititalizer(DataInitializerType dataInitializerType, ServicesHolder servicesHolder) {
        switch (dataInitializerType) {
            case IN_MEMORY: {
                return new InMemoryInitializer(servicesHolder);
            }
            case FROM_TXT_FILE: {
                return new FileInitializer(servicesHolder);
            }
            case FROM_XML: {
                return new XmlInitializer(servicesHolder);
            }
            default: {
                throw new RuntimeException("Unknown initializer for '" + dataInitializerType + "'");
            }
        }
    }
}
