package ru.yusdm.stud.lesson_1_data_types;

public class LangConstructions_2 {

    public static void main(String[] args) {
        //demoIfElse_2();
        // demoFor_3();
        // demoWhile_4();
        //demoDoWhile_5();
        //demoEndLessBreak_6();

        //demoNoSwitchBreak_11();

        calcEquation(1, 2, 3);
        calcEquation(1, 2, 3);
        calcEquation(1, 2, 3);
        calcEquation(1, 2, 3);
    }

    private static void demoIf_1() {
        if (System.currentTimeMillis() % 2 == 0) {
            System.out.println(" % 2 is true");
        }
    }

    private static void demoIfElse_2() {
        if (System.currentTimeMillis() % 2 == 0) {
            System.out.println(" % 2 is true");
        } else {
            System.out.println(" % 2 is false");
        }
    }

    private static void demoFor_3() {
        int result = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("total " + result);
            result = result + 10;
        }

        System.out.println("Result " + result);
    }

    private static void demoWhile_4() {
        int result = 0;

        while (result < 100) {
            System.out.println("total " + result);
            result = result + 10;
        }

        System.out.println("Result " + result);
    }

    private static void demoDoWhile_5() {
        int result = 100;

        do {
            System.out.println("total " + result);
            result = result + 10;
        } while (result < 100);

        System.out.println("Result " + result);
    }

    private static void demoEndLessBreak_6() {
        int result = 0;

        for (; ; ) {
            result += 10;

            if (result == 100) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void demoEndLessReturn_7() {
        int result = 0;

        for (; ; ) {
            result += 10;

            if (result == 100) {
                System.out.println(result);
                return;
            }
        }
    }

    private static void demoNoSwitch_8() {
        int age = 18;

        if (age == 18) {
            System.out.println("Beer");
        } else if (age == 19) {
            System.out.println("Good beer");
        } else if (age == 20) {
            System.out.println("Best beer");
        }
    }

    private static void demoSwitchNoBreak_10() {
        int age = 18;
        switch (age) {
            case 18: {
                System.out.println("Beer");
            }
            case 19: {
                System.out.println("Good Beer");
            }
            case 20: {
                System.out.println("Best Beer");
            }
        }

    }

    private static void demoNoSwitchBreak_11() {
        int age = 18;

        switch (age) {
            case 18: {
                System.out.println("Beer");
                break;
            }
            case 19: {
                System.out.println("Good Beer");
                break;
            }

            case 20:
            case 21: {
                System.out.println("Best Beer");
                break;
            }

            default: {
                System.out.println("aNY BEER YOU WANT");
            }
        }

    }

    private static void calcEquation(float a, float b, float c) {

    }


}
