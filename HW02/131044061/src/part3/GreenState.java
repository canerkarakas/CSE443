package part3;

public class GreenState implements State{
    TrafficLight trafficLight;

    public GreenState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    @Override
    public void red() {
        System.out.println("Traffic light is green. You have not switch to green");
    }

    @Override
    public void yellow() {
        System.out.println("Traffic light is green. You have not switch to red");
    }

    @Override
    public void green() {
        System.out.println("Traffic light switches yellow after "+ trafficLight.getTimeout_X() + " seconds");
        trafficLight.setTraffic_lamb("Yellow");
        trafficLight.setCurrent(trafficLight.getYellowState());
    }
}
