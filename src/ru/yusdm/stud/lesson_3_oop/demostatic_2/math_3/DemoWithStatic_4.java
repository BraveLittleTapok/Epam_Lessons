package ru.yusdm.stud.lesson_3_oop.demostatic_2.math_3;

public class DemoWithStatic_4 {

    public String toUpperCase3333(String s) {
        System.out.println("Send data to db");
        return s.toUpperCase();
    }

    public static String toLowerCase3333Static(String s) {
        System.out.println("Send data to db");
        return s.toLowerCase();
    }


    public static void main(String[] args) {

        DemoWithStatic_4 demoWithStatic_4 = new DemoWithStatic_4();
        demoWithStatic_4.toUpperCase3333("aa");

        DemoWithStatic_4.toLowerCase3333Static("AAAA");
    }
}
