package ru.yusdm.stud.lesson_1_data_types;

public class DemoTypes_1 {

    public static void main(String[] args) {
        //demoPrimitivesNumeric_1();
        //demoPrimitivesNumeric_2();
        //demoBooleanPrimitive_3();
        //demoBooleanPrimitive_4();
        // demoBoolean_5();

      /*  System.out.println(getCash("Ivan"));

        Integer cash = getCash("Semen");
        if (cash != null) {
            System.out.println("Semen's cash " + cash);
        } else {
            System.out.println("Doesn't buy a ticket");
        }*/
        // demoBoxUnbox_6();

        // demoString_7();

        demoArrays();
    }

    public static void demoPrimitivesNumeric_1() {
        int a = 5;
        int b = 5;

        int c = a + b;
        int d = c - b;

        long cc = 5;
        c = a * b;
        c = a / b;

        System.out.println(30 / 5);
        System.out.println(30 / 7);
    }

    public static void demoPrimitivesNumeric_2() {
        float a = 5;
        float b = 5;

        float c = a + b;
        float d = c - b;

        double dd = a;

        c = a * b;
        c = a / b;

        System.out.println(30f / 5);
        System.out.println(30f / 7);
    }

    public static void demoBooleanPrimitive_3() {
        boolean t = true;
        boolean f = false;

        System.out.println(t && f);
        System.out.println(t || f);
    }

    public static Integer getCash(String name) {
        if ("Ivan".equals(name)) {
            return 10;
        }

        if ("Petr".equals(name)) {
            return 0;
        }

        return null;
    }

    public static void demoBooleanPrimitive_4() {
        boolean b1 = validate("1234") && validate("123") || validate("55");
    }

    public static void demoBoolean_5() {
        boolean b1 = validate("1234") & validate("123");
        System.out.println(b1);
    }

    public static boolean validate(String s) {
        System.out.println("Validate " + s);

        if (s.length() > 3) {
            return false;
        } else {
            return true;
        }
    }

    public static void demoBoxUnbox_6() {
        //boxing
        Integer a = 8;

        //unboxing
        int i = a;


        Integer k = null;
        if (k != null) {
            i = k;
        }

    }

    public static void demoString_7() {
        String s = "a" + "bcd";
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(s.contains("bcd"));
    }


    public static void demoArrays() {
        int[] arr = new int[3];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        //arr = new int[66];

        //Danger
        //arr[55]  =  2;

        String[] arrStr = new String[]{"a", "b"};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

}
