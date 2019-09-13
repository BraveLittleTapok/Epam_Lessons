package src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.datainitializer;

import src.ru.yusdm.stud.lesson_8_collections_continue.homework.intializer.serviceinitializer.ServicesHolder;
import src.ru.yusdm.stud.lesson_8_collections_continue.homework.common.utils.*;
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
            default: {
                throw new RuntimeException("Unknown initializer for '" + dataInitializerType + "'");
            }
        }
    }
}
