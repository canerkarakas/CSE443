package MidTermPack4;

import java.util.ArrayList;

public class DiscreteCosineTransform extends DiscreteTransform{

    @Override
    public ArrayList<Double> transformSolverAlgorithm(ArrayList<Double> inputArray) {
        ArrayList<Double> outputArray = new ArrayList<>();
        int N = inputArray.size();
        double piDivideN = Math.PI / (double) N;
        int n=0, k=0;
        while(n<N){
            double sum = 0.0;
            k=0;
            while (k<N){
                sum = sum + (Math.cos(n*piDivideN*(0.5 + k)) * inputArray.get(k));
                k++;
            }
            outputArray.add(sum);
            n++;
        }
        return outputArray;
    }
}
