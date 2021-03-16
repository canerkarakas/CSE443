package PART1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class GaussianElimination implements LinearEquationsSolver {

    /**
     * Applies the gaussian elimination method to a given linear equation system until
     * it finds a solution. Swaps rows if it cannot find a solution. Returns
     * null after all permutations.
     * @return the solution of the linear equation system
     */
    @Override
    public List<Double> solution(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> constants) {

        List<Double> solution = gaussian(matrix, constants);

        if (solution != null) {
            if (solution.isEmpty()) {
                return null;
            }
            return solution;
        }

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = i; j < matrix.size(); j++) {
                Collections.swap(matrix, i, j);
                Collections.swap(constants, i, j);

                solution = gaussian(matrix, constants);

                if (solution != null) {
                    if (solution.isEmpty()) {
                        return null;
                    }
                    return solution;
                }

                Collections.swap(matrix, i, j);
                Collections.swap(constants, i, j);
            }
        }

        return null;
    }


    private void copyMatrix (ArrayList<ArrayList<Double>> matrix, ArrayList<ArrayList<Double>> matrix0){
        for (ArrayList<Double> row : matrix0) {
            matrix.add(new ArrayList<>(row));
        }
    }

    /**
     * @param matrix matrix of the linear equation system
     * @param rowNum number of the linear equation system's row
     * @param colNum number of the linear equation system's column
     * @return If any of the pivots is zero, return value is false
     */
    private boolean echelonForm(ArrayList<ArrayList<Double>> matrix, int rowNum, int colNum){

        Double multi;
        for (int i = 0; i < rowNum - 1; i++) {
            for (int j = i+1; j < rowNum; j++) {
                multi = matrix.get(j).get(i) / matrix.get(i).get(i);
                // If any of the pivots is zero
                if (multi.isNaN() || multi.isInfinite()) {
                    return false;
                }
                for (int k = i; k <= colNum; k++) {
                    double val = matrix.get(j).get(k);
                    matrix.get(j).set(k, val - matrix.get(i).get(k) * multi);
                }
            }
        }
        return true;
    }

    /**
     * @param matrix matrix of the linear equation system
     * @param rowNum number of the linear equation system's row
     * @param colNum number of the linear equation system's column
     * @return If the sum of the last row  is zero, return value is false
     */
    private boolean checkLastRow(ArrayList<ArrayList<Double>> matrix, int rowNum, int colNum){
        Double sum = 0.0;
        for (int i = 0; i < colNum; i++)
            sum += matrix.get(rowNum-1).get(i);

        return sum != 0.0;
    }

    /**
     * @param matrix matrix of the linear equation system
     * @param rowNum number of the linear equation system's row
     */
    private void extractSolutionValues(ArrayList<ArrayList<Double>> matrix, List<Double> solution, int rowNum){
        Double val;
        for (int i = rowNum - 1; i > -1; i--) {
            val = matrix.get(i).get(rowNum);
            for (int j = rowNum - 1; j > i; j--)
                val -= solution.get(j) * matrix.get(i).get(j);
            solution.set(i, val / matrix.get(i).get(i));
        }
    }

    /**
     * Applies gaussian elimination without row switching to given matrix and
     * solution system. Returns null in case of any errors.
     * @param matrixO matrix of the linear equation system
     * @param constants results of the linear equations
     * @return solution of the linear equation system
     */
    private List<Double> gaussian(ArrayList<ArrayList<Double>> matrixO, ArrayList<Double> constants) {

        ArrayList<ArrayList<Double>> matrix = new ArrayList<>();
        copyMatrix(matrix, matrixO);
        ArrayList<Double> results = new ArrayList<>(constants);
        int rowNum = matrix.size();
        int colNum = matrix.get(0).size();

        List<Double> solution = new ArrayList<>(rowNum);

        // Generate solution matrix
        for (int i = 0; i < rowNum; i++) {
            solution.add(0.0);
        }

        // If number of equations are less than number of unknowns
        if (colNum < rowNum) {
            return null;
        }

        // Get augmented matrix
        for (int i = 0; i < colNum; i++) {
            matrix.get(i).add(results.get(i));
        }

        // Get echelon form
        if (!echelonForm(matrix, rowNum, colNum))
            return null;

        // Check the last row
        if (!checkLastRow(matrix, rowNum, colNum))
            return Collections.emptyList();

        //extract solution
        extractSolutionValues(matrix, solution, rowNum);
        return solution;
    }

}
