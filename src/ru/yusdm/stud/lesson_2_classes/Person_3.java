package ru.yusdm.stud.lesson_2_classes;

public class Person_3 {

    int age;
    String name;
    String lastName;
    String car;
    String foreignPassportSerial;

    public Person_3() {
        System.out.println("Person created");
        this.name = "UNKNOWN NAME";
    }

    public Person_3(int i) {
        System.out.println("Person created");
        this.name = "UNKNOWN NAME";
    }

    public Person_3(String i) {
        this.lastName = i;
        System.out.println("Person created");
        this.name = "UNKNOWN NAME";
    }


    public Person_3(int age, String name333, String lastName) {
        this();
        this.age = age;
        this.lastName = lastName;
        this.name = name333;
    }

    private static void demoConstructorWithParameters() {
        Person_3 person = new Person_3(21, "Ivan", "Ivanov");
        System.out.println(person.name);
        System.out.println(person.lastName);
        System.out.println(person.age);
    }

    private static void demoSimpleConstructor_1() {
        Person_3 person = new Person_3();

        boolean isMonday = false;
        if (isMonday) {
            person.age = 33;
            person.name = "NAME was born  on mondaY";
            person.lastName = "LastName";
        } else {
            person.age = 33;
            person.name = "NAME was born not mondaY";
            person.lastName = "LastName";
        }

        boolean hasForeignPassport = true;
        if (hasForeignPassport) {
            person.foreignPassportSerial = "123";
        }
    }


    public static void main(String[] args) {
        demoConstructorWithParameters();
    }
}
