package ru.yusdm.stud.lesson_4_oop_continue.inheritence_2.instance_of_and_getclass_5;

public class Demo {
    private static class Car{}

    private static class PassengerCar extends Car{}
    private static class TruckCar extends Car{}

    private static class BMW extends PassengerCar{}
    private static class Kamaz extends TruckCar{}
    private static class Ural extends TruckCar{ void ural(){}}

    private static void carWashNoPolymorphism(Object car){
        System.out.println("Wash car");

        if (car instanceof TruckCar){
            System.out.println("Intensive car wash");
        }

        if (car instanceof PassengerCar){
            System.out.println("Soft wash");
        }

        if (car.getClass().equals(Ural.class)){
            ((Ural)car).ural();
            System.out.println("Wash ural");
        }
    }

    private static void carWashPolymorphism(Car car){
        System.out.println("Wash car");

        if (car instanceof TruckCar){
            System.out.println("Intensive car wash");
        }

        if (car instanceof PassengerCar){
            System.out.println("Soft wash");
        }

        if (car.getClass().equals(Ural.class)){
            ((Ural)car).ural();
            System.out.println("Wash ural");
        }
    }

    public static void main(String[] args) {
        carWashNoPolymorphism(new BMW());
        System.out.println("=============");
        carWashNoPolymorphism(new Kamaz());
        System.out.println("=============");
        carWashNoPolymorphism(new Ural());
    }
}
