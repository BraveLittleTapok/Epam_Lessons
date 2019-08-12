package ru.yusdm.stud.lesson_2_classes.complex_person;

public class Person {
    String name;
    String lastName;
    int age;
    int passportSerial;
    int passportNumber;

    String addressHouse;
    String addressFloor;
    int addressApartmentNumber;

    public Person() {
    }

    public Person(String name, String lastName,
                  int age, int passportSerial,
                  int passportNumber) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
    }

    public Person(String name,
                  String lastName,
                  int age,
                  int passportSerial,
                  int passportNumber,
                  String addressHouse,
                  String addressFloor,
                  int addressApartmentNumber) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.passportSerial = passportSerial;
        this.passportNumber = passportNumber;
        this.addressHouse = addressHouse;
        this.addressFloor = addressFloor;
        this.addressApartmentNumber = addressApartmentNumber;
    }

    public static void main(String[] args) {
        Person person = new Person("Ivan", "Ivanov", 11, 22, 33);
        Person person2 = new Person("Ivan", "Ivanov", 11, 22, 33,"a1","22",33);

        Person person3 = new Person();
        person3.lastName ="Ivanov";
        person3.name = "Ivan";
    }

}
