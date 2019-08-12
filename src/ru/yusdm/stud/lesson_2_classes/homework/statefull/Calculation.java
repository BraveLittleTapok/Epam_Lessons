package ru.yusdm.stud.lesson_2_classes.homework.statefull;

public class Calculation {

    private InputData inputData;

    public Calculation(InputData inputData) {
        this.inputData = inputData;
    }

    private double getD() {
        return inputData.getB() * inputData.getB()
                - 4 * inputData.getA() * inputData.getC();
    }


    public Solution calc() {
        Solution solution = new Solution();

        if (inputData.isValid()) {
            double d = getD();

            if (d >= 0) {
                solution.setX1(1.);
                solution.setX2(2.);
            }
        }

        return solution;
    }

}
