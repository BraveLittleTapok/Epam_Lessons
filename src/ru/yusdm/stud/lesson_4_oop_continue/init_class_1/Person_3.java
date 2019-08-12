package ru.yusdm.stud.lesson_4_oop_continue.init_class_1;

public class Person_3 {
    {
        System.out.println("Init block 2");
        name = "Name";
    }
    private static int testStatic = 0;
    private int age = getInitedAge();
    private String name;

    static {
        System.out.println("Static call 1");
        testStatic = 99;
    }

    public Person_3() {
        System.out.println("Constructor call " + age +" 4");
    }

    private int getInitedAge() {
        System.out.println("Init age 3");
        return 100;
    }

    public static void main(String[] args) {
        new Person_3();
        //
        System.out.println();
        new Person_3();
    }
}
