package ru.yusdm.stud.lesson_3_oop.defvarvalues_1;

public class DemoDefaultVars {

    private String name = "Ivan";
    private Integer ii;
    private boolean b;

    private void demoDeclareVarAsClassMember(){
        System.out.println(ii);
        System.out.println(b);
    }

    private void demoDeclareVarInMethod(){
        int a = 0;
        Integer i = 1;
        System.out.println(a);
        System.out.println(i);
    }



    public static void main(String[] args) {
        DemoDefaultVars demoStatic =null;
        System.out.println(demoStatic.name);
    }
}
