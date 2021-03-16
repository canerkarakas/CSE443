package PART1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        test1();
    }

    private static void test1(){

        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        ArrayList<Double> constants = new ArrayList<>();
        ArrayList<Double> temp;
        Scanner scanner = new Scanner(System.in);
        int row, column;

        System.out.println("Enter row number : ");
        row = scanner.nextInt();
        System.out.println("Enter column number : ");
        column = scanner.nextInt();
        for (int i = 0; i<row; i++){
            System.out.println("Enter the "+ i + ". equation's coefficients : ");
            temp = new ArrayList<>(column);
            for (int j=0; j<column; j++){
                temp.add(scanner.nextDouble());
            }
            matrix.add(temp);
        }
        System.out.println("Enter the constants that results of equations : ");
        for (int i = 0; i<row; i++)
            constants.add(scanner.nextDouble());


        GaussianElimination gaussianElimination = new GaussianElimination();
        MatrixInversion matrixInversion = new MatrixInversion();
        LinearEquations linearEquations = new LinearEquations(matrix, constants);
        boolean control = true;
        System.out.println("1-Gaussian Elimination  2-Matrix Inversion");
        System.out.println("Enter 1 or 2 for the choosing mode. If you want to exit, please enter a different number.");
        do {
            int chooseMode;
            chooseMode = scanner.nextInt();
            List<Double> solution;
            switch (chooseMode) {
                case 1 -> {
                    linearEquations.setLes(gaussianElimination);
                    solution = linearEquations.calculater();
                    if (solution == null)
                        System.out.println("The equation couldn't be solved with GaussianElimination");
                    else
                        System.out.println("Gaussian Elimination : " + solution);
                }
                case 2 -> {
                    linearEquations.setLes(matrixInversion);
                    solution = linearEquations.calculater();
                    if (solution == null)
                        System.out.println("The equation couldn't be solved with matrixInversion");
                    else
                        System.out.println("Matrix Inversion : " + solution);
                }
                default -> control = false;
            }
        }while (control);
    }

}
