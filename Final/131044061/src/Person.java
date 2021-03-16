import java.awt.*;
import java.util.Random;

public class Person {
    private Waiting waitingCollision;
    private Waiting waitingHospital;
    private Waiting waiting;
    private int x_coordinate;
    private int y_coordinate;
    private double M;
    private int S;
    private int D;
    private int C;
    private double P;
    private int situation = 0; //0=healthy, 1=infected, 2=at hospital, 3=dead
    private boolean queueAtHospital = false;
    private int direction; // 0=north , 1=east, 2=south, 3=west
    private Color color = Color.BLACK; //healthy=BLACK, infected=GREEN, hospital=white, dead=RED
    private boolean invisible = false; //true=magenta, false=color
    private Mediator mediator;
    static double R = 0.5;
    static double Z = 0.1;
    private int waitingHospitalTime = (int) (100 * (1-Z));
    private boolean die = false;

    public Person(){
        Random random = new Random();
        x_coordinate = random.nextInt(1000);
        y_coordinate = random.nextInt(600);
        int random_masked = random.nextInt(2);
        if (random_masked == 1)
            M = 0.2;
        else M = 1.0;
        S = random.nextInt(500)+1;
        D = random.nextInt(9)+1;
        C = random.nextInt(5)+1;
        direction = random.nextInt(4);
        waitingCollision = new CollisionWaiting(this);
        waitingHospital = new HospitalWaiting(this);
    }

    public void walk(){
        switch (direction) {
            case 0:
                if (y_coordinate - S <= 10)
                    newDirection();
                y_coordinate -= S;
                break;
            case 1:
                if (x_coordinate + S >= 1000)
                    newDirection();
                x_coordinate += S;
                break;
            case 2:
                if (y_coordinate + S >= 600)
                    newDirection();
                y_coordinate += S;
                break;
            case 3:
                if (x_coordinate - S <= 10)
                    newDirection();
                x_coordinate -= S;
                break;
            default:
                break;
        }
        mediator.walk(this);
    }

    public void setQueueAtHospital(boolean queueAtHospital) {
        this.queueAtHospital = queueAtHospital;
    }

    public boolean isQueueAtHospital() {
        return queueAtHospital;
    }

    public double getP() {
        return P;
    }

    public void setWaiting(Waiting waiting) {
        this.waiting = waiting;
    }

    public Waiting getWaitingHospital() {
        return waitingHospital;
    }

    public Waiting getWaiting() {
        return waiting;
    }

    public int getWaitingHospitalTime() {
        return waitingHospitalTime;
    }

    public void setWaitingHospitalTime(int waitingHospitalTime) {
        this.waitingHospitalTime = waitingHospitalTime;
    }

    public void setP(double p) {
        P = p;
    }

    private void newDirection(){
        Random random = new Random();
        if (direction==0 || direction==3){
            if (direction==0)
                direction = random.nextInt(2) + 1;
            else
                direction = random.nextInt(3);
        }
        else {
            int tempDirection = random.nextInt(direction);
            int tempDirection2 = (int) (Math.random() * (3 - direction) + direction+1);
            int tempDirection3 = random.nextInt(2);
            if (tempDirection3 == 0)
                direction = tempDirection;
            else direction = tempDirection2;
        }
    }

    public Waiting getWaitingCollision() {
        return waitingCollision;
    }

    public void setDie(boolean die) {
        this.die = die;
        this.situation = 3;
        this.color = Color.RED;
        this.invisible = true;
    }

    public boolean getDie(){
        return die;
    }

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
        this.mediator.addPerson(this);
    }

    public int getX_coordinate() {
        return x_coordinate;
    }

    public Mediator getMediator() {
        return mediator;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }

    public double getM() {
        return M;
    }

    public int getC() {
        return C;
    }

    public int getD() {
        return D;
    }

    public int getS() {
        return S;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void setInvisible(boolean invisible) {
        this.invisible = invisible;
        if (this.invisible && this.getSituation() == 0)
            this.color = Color.magenta;
    }

    public void goHospital(){
        this.situation = 2;
        setInvisible(true);
    }

    public boolean getInvisible() { return invisible; }

    public void setSituation(int situation) {
        this.situation = situation;
        switch (this.situation){
            case 0: this.color=Color.BLACK;break;
            case 1: this.color=Color.GREEN;break;
            case 2: this.color=Color.white;break;
            default:break;
        }
    }

    public Color getColor() {
        return color;
    }

    public int getSituation() {
        return situation;
    }

    public void waiting(int waitingTime){
        waiting.waiting(waitingTime);
    }

    /*public void collisionWaiting(int waitingTime){
        waitingCollision.waiting(waitingTime);
    }*/

    /*public void hospitalWaiting(int waitingTime){
        waitingHospital.waiting(waitingTime);
    }*/


}
