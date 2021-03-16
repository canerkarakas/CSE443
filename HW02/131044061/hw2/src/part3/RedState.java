package part3;

public class RedState implements State{
    TrafficLight trafficLight;

    public RedState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    @Override
    public void red() {
        System.out.println("Traffic light switches green after 15 seconds");
        trafficLight.setTraffic_lamb("Green");
        trafficLight.setCurrent(trafficLight.getGreenState());
    }

    @Override
    public void yellow() {
        System.out.println("Traffic light is red. You have not switch to yellow");
    }

    @Override
    public void green() {
        System.out.println("Traffic light is red. You have not switch to green");
    }
}
