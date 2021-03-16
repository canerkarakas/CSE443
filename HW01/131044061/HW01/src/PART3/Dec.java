package PART3;

public class Dec extends Suit {

    public Dec() {
        description = "Dec";
    }

    @Override
    public float getCost() {
        return 500;
    }

    @Override
    public float getWeight() {
        return 25;
    }
}
