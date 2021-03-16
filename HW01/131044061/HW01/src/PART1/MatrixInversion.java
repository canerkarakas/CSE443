package PART1;

import java.util.ArrayList;
import java.util.List;

public class MatrixInversion implements LinearEquationsSolver{
    @Override
    public List<Double> solution(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> constants) {
        ArrayList<Double> solution = new ArrayList<>();
        ArrayList<ArrayList<Double>> inv = inverse(matrix);
        if (inv == null) {
            return null;
        }

        double last;

        for (ArrayList<Double> row : inv) {
            last = 0.0;
            for (int i = 0; i < row.size(); i++) {
                last += row.get(i) * constants.get(i);
            }
            solution.add(last);
        }

        return solution;
    }

    /**
     * Returns inverse of a matrix
     * @param matrix input matrix
     * @return inverse of the given matrix
     */
    private ArrayList<ArrayList<Double>> inverse(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> inverseList = new ArrayList<>();

        ArrayList<ArrayList<Double>> adj = adj(cofactors(matrix));
        Double det = determinant(matrix);

        if (det == 0) {
            return null;
        }

        for (ArrayList<Double> row : adj) {
            inverseList.add(new ArrayList<>());
            for (Double elm : row)
                inverseList.get(inverseList.size()-1).add(elm*(1/det));
        }

        return inverseList;
    }

    /**
     * Returns adj of a given input matrix
     * @param matrix input matrix
     * @return adj of the input matrix
     */
    ArrayList<ArrayList<Double>> adj(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> adjg = new ArrayList<>();

        for (int j = 0; j < matrix.size(); j++) {
            adjg.add(new ArrayList<>());
            for (ArrayList<Double> doubles : matrix) adjg.get(j).add(doubles.get(j));
        }
        return adjg;
    }

    /**
     * Returns matrix of cofactors of a given matrix
     * @param matrix input matrix
     * @return matrix of cofactors for given matrix
     */
    private ArrayList<ArrayList<Double>> cofactors(ArrayList<ArrayList<Double>> matrix) {
        ArrayList<ArrayList<Double>> cofactorsMatrix = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            cofactorsMatrix.add(new ArrayList<>());
            for (int j = 0; j < matrix.size(); j++) {
                ArrayList<ArrayList<Double>> result = new ArrayList<>();
                for (int k = 0; k < matrix.size(); k++) {
                    if (k == i) continue;
                    result.add(new ArrayList<>());
                    for (int l = 0; l < matrix.size(); l++) {
                        if (l == j) continue;
                        result.get(result.size()-1).add(matrix.get(k).get(l));
                    }
                }
                cofactorsMatrix.get(cofactorsMatrix.size()-1).add(determinant(result) * Math.pow(-1, i+j));
            }
        }
        return cofactorsMatrix;
    }

    /**
     * Returns determinant of a given matrix
     * @param matrix input matrix
     * @return determinant of the input matrix
     */
    private Double determinant(ArrayList<ArrayList<Double>> matrix) {
        if (matrix.size() == 2) {
            Double a, b, c, d;
            a = matrix.get(0).get(0);
            b = matrix.get(0).get(1);
            c = matrix.get(1).get(0);
            d = matrix.get(1).get(1);

            return a*d - b*c;
        }

        double last = 0d;
        for (int i = 0; i < matrix.size(); i++) {
            ArrayList<ArrayList<Double>> rest = new ArrayList<>();
            for (int j = 1; j < matrix.size(); j++) {
                rest.add(new ArrayList<>());
                for (int k = 0; k < matrix.size(); k++) {
                    if (k == i) continue;
                    rest.get(j-1).add(matrix.get(j).get(k));
                }
            }

            last += Math.pow(-1, i) * matrix.get(0).get(i) * determinant(rest);
        }

        return last;
    }
}
