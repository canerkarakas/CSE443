import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Main.RZ();
        ModelInterface modelInterface = new ModelClass();
        ControllerInterFace controllerInterFace = new ControllerClass(modelInterface);
    }

    private static void RZ(){
        Random random = new Random();
        switch (random.nextInt(6)){
            case 0:Person.R = 0.5;break;
            case 1:Person.R = 0.6;break;
            case 2:Person.R = 0.7;break;
            case 3:Person.R = 0.8;break;
            case 4:Person.R = 0.9;break;
            case 5:Person.R = 1.0;break;
            default:break;
        }

        switch (random.nextInt(9)){
            case 0:Person.Z = 0.1;break;
            case 1:Person.Z = 0.2;break;
            case 2:Person.Z = 0.3;break;
            case 3:Person.Z = 0.4;break;
            case 4:Person.Z = 0.5;break;
            case 5:Person.Z = 0.6;break;
            case 6:Person.Z = 0.7;break;
            case 7:Person.Z = 0.8;break;
            case 8:Person.Z = 0.9;break;
            default:break;
        }
    }
}
