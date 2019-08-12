package ru.yusdm.stud.lesson_2_classes.homework.statefull;

public class StatelessEquation {

    public Solution calculate(InputData inputData) {
        Calculation calculation = new Calculation(inputData);
        Solution solution = calculation.calc();
        return solution;
    }

    public void printResults(Solution solution) {
        SolutionConsumer solutionConsumer = new SolutionConsumer(solution);
        solutionConsumer.printSolution();
    }

    public static void main(String[] args) {
        InputData inputData = new InputData(1, 2, 3);

        StatelessEquation equation = new StatelessEquation();
        Solution solution = equation.calculate(inputData);
        equation.printResults(solution);

        System.out.println();
    }
}
