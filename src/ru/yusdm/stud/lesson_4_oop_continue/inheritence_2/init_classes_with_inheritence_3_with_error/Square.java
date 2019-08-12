package ru.yusdm.stud.lesson_4_oop_continue.inheritence_2.init_classes_with_inheritence_3_with_error;

public class Square extends Figure {
    private Integer side;

    {
        System.out.println("Init in child");
    }

    static {
        System.out.println("Init in child static");
    }

    public Square() {
        System.out.println("Child constructor");
    }

    @Override
    public int getSquare() {
        super.getSquare();
        return side * side;
    }

    @Override
    public String getFigureAsStringValue() {
        System.out.println("Method in child");
        return side.toString() + " X " + side.toString();
    }

    public static void main(String[] args) {
        Square square = new Square();
    }
}
