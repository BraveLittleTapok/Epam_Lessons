package ru.yusdm.stud.lesson_2_classes.homework.statefull;

public class InputData {
    private double a, b, c;

    public InputData(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public boolean isValid() {
        return a != 0;
    }

    public double getC() {
        return c;
    }

    public double getD() {
        return b * b - 4 * a * c;
    }
}
