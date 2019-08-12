package ru.yusdm.stud.lesson_2_classes.homework.statefull;

public class SolutionConsumer {
    private Solution solution;

    public SolutionConsumer(Solution solution) {
        this.solution = solution;
    }

    public void printSolution() {
        boolean hasSolutions = solution.hasSolution();

        if (hasSolutions) {
            System.out.println("X1 = " + solution.getX1() + "; X2 = " + solution.getX2());
        } else {
            System.out.println("Not solutions, or any error!");
        }

    }
}
