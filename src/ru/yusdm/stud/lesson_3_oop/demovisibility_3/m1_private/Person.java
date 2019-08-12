package ru.yusdm.stud.lesson_3_oop.demovisibility_3.m1_private;

public class Person {
    private String name;
    private String lastName;

    private void demoPrivateMethod() {
    }

    public String getName44() {
        return name;
    }

    public void setName55(String name) {
        this.name = name;
    }

    public void copy(Person person) {
        String s = person.name;
        person.demoPrivateMethod();
    }
}
