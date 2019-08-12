package ru.yusdm.stud.lesson_4_oop_continue.inheritence_2.init_classes_with_inheritence_4_no_error;

public class Figure {

    {
        System.out.println("Init in parent");
    }

    static {
        System.out.println("Init in parent static");
    }

    public Figure() {
        System.out.println("Constructor in parent " + getFigureAsStringValue());
        System.out.println("Init constructor in parent");
    }

    private String getFigureAsStringValueMine(){
        System.out.println("Method in parent");
        return "";
    }

    public String getFigureAsStringValue(){
        return getFigureAsStringValueMine();
    }

    public int getSquare(){
        System.out.println("Super call - calculate square");
        return 0;
    }
}
