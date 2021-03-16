package PART1;

import java.util.ArrayList;
import java.util.List;

public class LinearEquations {
    private LinearEquationsSolver les;
    private ArrayList<ArrayList<Double>> matrix;
    private ArrayList<Double> constants;

    public LinearEquations(ArrayList<ArrayList<Double>> matrix, ArrayList<Double> constants){
        this.matrix = matrix;
        this.constants = constants;
    }

    public void setMatrix(ArrayList<ArrayList<Double>> matrix) {
        this.matrix = matrix;
    }

    public void setConstants(ArrayList<Double> constants){
        this.constants = constants;
    }

    public ArrayList<ArrayList<Double>> getMatrix() {
        return this.matrix;
    }

    public ArrayList<Double> getConstants() {
        return constants;
    }

    public void setLes(LinearEquationsSolver les) {
        this.les = les;
    }

    public List<Double> calculater(){
        return this.les.solution(this.matrix, this.constants);
    }
}
