package ru.yusdm.stud.lesson_2_classes.complex_person.withinnerobjects;

public class Person {
    String name;
    String lastName;
    int age;
    Passport passport;

    public Person(String name, String lastName, int age, Passport passport) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.passport = passport;
    }

    public static void main(String[] args) {
        Passport passport = new Passport(11, 22);
        Person person = new Person("Ivan", "Ivanov", 33, passport);

    }
}
