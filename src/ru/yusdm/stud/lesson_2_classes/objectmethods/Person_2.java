package ru.yusdm.stud.lesson_2_classes.objectmethods;

import ru.yusdm.stud.lesson_2_classes.complex_person.withinnerobjects.Person;

public class Person_2 {
    private String name;
    private String lastName;

    public Person_2(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name = " + name + " ; LastName = " + lastName;
    }

    public static void main(String[] args) {
        Person_2 person = new Person_2("Ivan", "Ivanov");
        System.out.println(person);
        System.out.println(person.toString());
    }
}
