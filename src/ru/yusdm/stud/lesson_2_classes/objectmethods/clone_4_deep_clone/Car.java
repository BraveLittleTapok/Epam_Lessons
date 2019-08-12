package ru.yusdm.stud.lesson_2_classes.objectmethods.clone_4_deep_clone;

public class Car implements Cloneable{
    private String name;
    private String color;
    private Engine engine;

    public Car(String name, Engine engine) {
        this.name = name;
        this.engine = engine;
    }

    public Car(Car car){
        copyActions(car, this);
    }

    private void copyActions(Car src, Car dest){
        dest.color = src.color;
        dest.name = src.name;
        dest.engine = new Engine(src.engine);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", engine=" + engine +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Car(this);
    }

    public static void main(String[] args) throws Exception {
        Engine engine = new Engine(19, 800);
        Car car = new Car("BMW", engine);
        car.color = "RED";
        System.out.println(car);

        Car car2 = (Car) car.clone();
        car2.color = "BLUE";
        car2.engine.setPower(20);
        System.out.println(car2);

        System.out.println("");
        System.out.println(car);
    }
}
