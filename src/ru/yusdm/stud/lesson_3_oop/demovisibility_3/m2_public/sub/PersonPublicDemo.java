package ru.yusdm.stud.lesson_3_oop.demovisibility_3.m2_public.sub;

import ru.yusdm.stud.lesson_3_oop.demovisibility_3.m2_public.PersonPublic;

public class PersonPublicDemo {

    public static void main(String[] args) {
        PersonPublic personPublic = new PersonPublic();
        System.out.println(personPublic.name);
        personPublic.printName();
    }
}
