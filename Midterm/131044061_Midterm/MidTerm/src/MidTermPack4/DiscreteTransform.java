package MidTermPack4;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public abstract class DiscreteTransform {
    public final void transform(String inputFileName, String outputFileName) throws IOException {
        ArrayList<Double> inputArray = readFileForInputArray(inputFileName);
        ArrayList<Double> outputArray = transformSolverAlgorithm(inputArray);
        writeFileForOutputArray(outputFileName, outputArray);
        if (chooseDFTExecutionTime()){
            hook();
        }
    }

    public final ArrayList<Double> readFileForInputArray(String inputFileName){
        String line;
        ArrayList<Double> inputArrayList = new ArrayList<>();
        try{
            FileReader file=new FileReader(inputFileName);
            BufferedReader bufferedReader=new BufferedReader(file);
            line=bufferedReader.readLine();
            StringTokenizer stringTokenizer = new StringTokenizer(line);
            while(stringTokenizer.hasMoreTokens()){
                inputArrayList.add(Double.parseDouble(stringTokenizer.nextToken()));
            }
            bufferedReader.close();
        }catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
        return inputArrayList;
    }

    private final void writeFileForOutputArray(String outputFileName, ArrayList<Double> outputArray) throws IOException {
        BufferedWriter bufferedWriter=null;
        FileWriter fileWriter = new FileWriter(outputFileName);
        bufferedWriter=new BufferedWriter(fileWriter);
        String content = "";
        for (int i=0;i<outputArray.size();i++){
            content += (outputArray.get(i)).toString() + "\t";
        }
        bufferedWriter.write(content);
        bufferedWriter.flush();
    }

    protected boolean chooseDFTExecutionTime(){
        return false;
    }

    protected void hook(){

    }



    public abstract ArrayList<Double> transformSolverAlgorithm(ArrayList<Double> inputArray);
}
