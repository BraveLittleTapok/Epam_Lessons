package ru.yusdm.stud.lesson_4_oop_continue.init_class_1;

public class Person_2 {

    private int age = getInitedAge();

    public Person_2() {
        System.out.println("Constructor call " + age);
    }

    private int getInitedAge(){
        System.out.println("Init age");
        return 100;
    }

    public static void main(String[] args) {
        new Person_2();
    }
}
