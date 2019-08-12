package ru.yusdm.stud.lesson_3_oop.demostatic_2;

public class GorillaStatic_2 {
    private String name;
    private int weight;
    private static String teeth = "Sharp";

    @Override
    public String toString() {
        return "GorillaStatic_2{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", teeth=" + teeth +
                '}';
    }

    public static void main(String[] args) {
        demoStaticWithoutCreateObjects();
    }

    private static void demoStaticWhileCreateObjects_1(){
        GorillaStatic_2 g1 = new GorillaStatic_2();
        g1.name = "Ivan";
        g1.weight = 100;
        GorillaStatic_2.teeth = "Sharp 33";

        GorillaStatic_2 g2 = new GorillaStatic_2();
        g2.name = "Isabella";
        g2.weight = 200;
        g2.teeth = "Sharp 22";

        System.out.println(g1);
        System.out.println(g2);
    }

    private static void demoStaticWithoutCreateObjects(){
        System.out.println(GorillaStatic_2.teeth);
    }
}
