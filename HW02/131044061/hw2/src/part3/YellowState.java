package part3;

public class YellowState implements State{
    TrafficLight trafficLight;

    public YellowState(TrafficLight trafficLight){
        this.trafficLight = trafficLight;
    }

    @Override
    public void red() {
        System.out.println("Traffic light is yellow. You have not switch to green");
    }

    @Override
    public void yellow() {
        System.out.println("Traffic light switches red after 3 seconds");
        trafficLight.setTraffic_lamb("Red");
        trafficLight.setCurrent(trafficLight.getRedState());
    }

    @Override
    public void green() {
        System.out.println("Traffic light is yellow. You have not switch to yellow");
    }
}
