package ru.yusdm.stud.lesson_2_classes.homework.statefull;

public class StatefullEquation {

    private InputData inputData;
    private Calculation calculation;
    private Solution solution;

    public StatefullEquation(InputData inputData) {
        this.inputData = inputData;
    }

    public void calculate() {
        calculation = new Calculation(inputData);
        solution = calculation.calc();
    }

    public void printResults() {
        SolutionConsumer solutionConsumer = new SolutionConsumer(solution);
        solutionConsumer.printSolution();
    }

    public static void main(String[] args) {
        InputData inputData = new InputData(1, 2, 3);

        StatefullEquation equation = new StatefullEquation(inputData);
        equation.calculate();
        equation.printResults();

        System.out.println();


    }
}
