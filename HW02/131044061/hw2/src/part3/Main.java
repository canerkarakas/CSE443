package part3;

public class Main {
    public static void main(String[] args) {
        HiTech hiTech = new HiTech();
        TrafficLight trafficLight = new TrafficLight();
        hiTech.registerObserver(trafficLight);
        System.out.println("----test1----");
        test(trafficLight);
        System.out.println("----change----");
        hiTech.changeDetected(true);
        test(trafficLight);
        System.out.println("----change 2----");
        hiTech.changeDetected(false);
        test(trafficLight);
        System.out.println("----wrong test----");
        wrongTest(trafficLight);
    }
    public static void test(TrafficLight trafficLight){
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.red();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.green();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.yellow();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
    }
    public static void wrongTest(TrafficLight trafficLight){
        trafficLight.yellow();
        trafficLight.yellow();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.red();
        trafficLight.green();
        trafficLight.green();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.green();
        trafficLight.red();
        trafficLight.red();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
        trafficLight.yellow();
        System.out.println("Traffic light is " + trafficLight.getTraffic_lamb());
    }
}
