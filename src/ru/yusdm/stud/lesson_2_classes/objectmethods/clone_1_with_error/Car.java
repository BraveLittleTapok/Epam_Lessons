package ru.yusdm.stud.lesson_2_classes.objectmethods.clone_1_with_error;

public class Car {
    private String mark;
    private int power;
    private String color;

    public Car(String mark, int power) {
        this.mark = mark;
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Car{" +
                "mark='" + mark + '\'' +
                ", power=" + power +
                ", color='" + color + '\'' +
                '}';
    }

    private static void demoNoClone_1() {
        Car car = new Car("BMW", 222);
        car.color = "RED";
        System.out.println(car);

        Car car2 = new Car("BMW", 222);
        car2.color = "BLUE";
        System.out.println(car2);
    }

    public static void main(String[] args) throws Exception {
        Car car = new Car("BMW", 222);
        car.color = "RED";
        System.out.println(car);

        Car car2 = (Car) car.clone();
        car2.color = "BLUE";

        System.out.println(car2);
        /*
        Car car3 = (Car) car.clone();
        car3.color = "GREEN";


        Car car4 = (Car) car.clone();
        Car car5 = (Car) car.clone();
        */


    }
}
