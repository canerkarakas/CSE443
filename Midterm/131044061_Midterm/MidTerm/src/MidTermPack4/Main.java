package MidTermPack4;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length != 0 && args[0] != null) {
            DiscreteTransform discreteTransform = new DiscreteCosineTransform();
            discreteTransform.transform(args[0], "outputForDCT.txt");
            discreteTransform = new DiscreteFourierTransform();
            discreteTransform.transform(args[0], "outputForDFT.txt");
        }
        else {
            System.out.println("Error args");
            System.out.println("Please enter input file path");
        }
    }
}
