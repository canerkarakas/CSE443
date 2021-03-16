package MidTermPack4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DiscreteFourierTransform extends DiscreteTransform{
    private double transformExecutionTime = 0.0;
    @Override
    protected boolean chooseDFTExecutionTime(){
        return returnChoose();
    }
    @Override
    protected void hook(){
        System.out.println("Transform Execution is " + transformExecutionTime + " ms!");
    }
    @Override
    public ArrayList<Double> transformSolverAlgorithm(ArrayList<Double> inputArray) {
        long start = System.nanoTime();
        ArrayList<Double> outputArray = new ArrayList<>();
        try {
            if (inputArray.size()%2 != 0){
                throw new InputMismatchException("Input array size must be even.\n");
            }
            int N = inputArray.size() / 2;
            for(int i=0;i<N;i++){
                double firstPart = 0.0;
                double secondPart = 0.0;
                for(int j=0;j<N;j++){
                    double angle = Math.PI / N * 2 * j * i;
                    firstPart = firstPart + (Math.cos(angle) * inputArray.get(2*j) + Math.sin(angle) * inputArray.get(2*j+1));
                    secondPart = secondPart + (Math.sin(angle) * inputArray.get(2*j)* -1 + Math.cos(angle) * inputArray.get(2*j+1));
                }
                outputArray.add(firstPart);
                outputArray.add(secondPart);
            }
        } catch (InputMismatchException e) {
            e.printStackTrace();
        }
        long finish = System.nanoTime();
        double diffTime = ((double)(finish - start)/1000000);
        transformExecutionTime = diffTime;
        return outputArray;
    }

    private boolean returnChoose(){
        System.out.println("Would you like to see the transform execution time?");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        choice = choice.toLowerCase();
        if (choice.startsWith("y")){
            return true;
        }
        return false;
    }
}
