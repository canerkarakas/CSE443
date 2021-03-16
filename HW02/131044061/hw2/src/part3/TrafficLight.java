package part3;

public class TrafficLight implements Observer{
    private String traffic_lamb;
    private State redState;
    private State yellowState;
    private State greenState;
    private State current;
    private int timeout_X = 60;

    public TrafficLight(){
        redState = new RedState(this);
        yellowState = new YellowState(this);
        greenState = new GreenState(this);
        current = redState;
        traffic_lamb = "Red";
    }

    public void red(){
        current.red();
    }

    public void yellow(){
        current.yellow();
    }

    public void green(){
        current.green();
    }

    public void setCurrent(State current) {
        this.current = current;
    }

    public State getCurrent() {
        return current;
    }

    public State getGreenState() {
        return greenState;
    }

    public State getRedState() {
        return redState;
    }

    public State getYellowState() {
        return yellowState;
    }

    public String getTraffic_lamb() {
        return traffic_lamb;
    }

    public int getTimeout_X() {
        return timeout_X;
    }

    public void setTimeout_X(int timeout_X) {
        this.timeout_X = timeout_X;
    }

    public void setTraffic_lamb(String traffic_lamb) {
        this.traffic_lamb = traffic_lamb;
    }

    @Override
    public void update(int time_x) {
        timeout_X = time_x;
    }
}
