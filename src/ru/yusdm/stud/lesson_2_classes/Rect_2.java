package ru.yusdm.stud.lesson_2_classes;

public class Rect_2 {
    int top;
    int right;
    int bottom;
    int left;

    int square;

    private double calcSquareStateless() {
        return (bottom - top) * (right - left);
    }

    private void calcSquareStatefull() {
        square = (bottom - top) * (right - left);
    }
}
