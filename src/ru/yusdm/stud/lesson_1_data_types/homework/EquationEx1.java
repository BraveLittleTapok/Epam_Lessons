package ru.yusdm.stud.lesson_1_data_types.homework;

public class EquationEx1 {


    public static void calc_1(double a, double b, double c) {

        if (a != 0) {
            double d = (Math.pow(b, 2) - 4 * a * c);
            if (d < 0) {
                System.out.println("No solutions");
            } else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                System.out.println("X1 = " + x1 + " ; X2 = " + x2);
            }
        } else {
            System.out.println("Not quadratic");
        }
    }


    public static void calc_2(double a, double b, double c) {
        if (a != 0) {
            double d = getD(a, b, c);
            if (hasRealDescisions(d)) {

                double x1 = getRoot1(a, b, d);
                double x2 = getRoot2(a, b, d);

                printRoots(x1, x2);
            } else {
                System.out.println("No solutions");
            }
        } else {
            System.out.println("Not quadratic");
        }
    }


    public static double getD(double a, double b, double c) {
        return (Math.pow(b, 2) - 4 * a * c);
    }

    public static boolean hasRealDescisions(double d) {
        return d >= 0;
    }

    public static double getRoot1(double a, double b, double d) {
        return (-b + Math.sqrt(d)) / (2 * a);
    }

    public static double getRoot2(double a, double b, double d) {
        return (-b - Math.sqrt(d)) / (2 * a);
    }

    public static void printRoots(double x1, double x2) {
        System.out.println("X1 = " + x1 + " ; X2 = " + x2);
    }
}
