package ru.yusdm.stud.lesson_2_classes.objectmethods.clone_4_deep_clone;

public class Engine {

    private int power;
    private int volume;


    public Engine(int power, int volume) {
        this.power = power;
        this.volume = volume;
    }

    public Engine(Engine engine) {
        cloneActions(engine, this);
    }

    private void cloneActions(Engine src, Engine dest) {
        dest.power = src.power;
        dest.volume = src.volume;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Engine{" +
                "power=" + power +
                ", volume=" + volume +
                '}';
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
