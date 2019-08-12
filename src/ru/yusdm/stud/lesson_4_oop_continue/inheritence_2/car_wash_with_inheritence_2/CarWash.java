package ru.yusdm.stud.lesson_4_oop_continue.inheritence_2.car_wash_with_inheritence_2;


public class CarWash {

    public void washCar(Car car) {
        System.out.println("Wash car in action");
    }

    private static void demoWashCars_1(){
        CarWash carWash = new CarWash();

        Bmw bmw = new Bmw();
        Mercedes mercedes = new Mercedes();

        carWash.washCar(bmw);
        carWash.washCar(mercedes);
    }

    public static void main(String[] args) {
        CarWash carWash = new CarWash();

        Bmw bmw = new Bmw();
        Mercedes mercedes = new Mercedes();

        carWash.washCar(bmw);
        carWash.washCar(mercedes);
        carWash.washCar(null);
    }

}
