package PART3;

public class Tor extends Suit {

    public Tor() {
        description = "Tor";
    }


    @Override
    public float getCost() {
        return 5000;
    }

    @Override
    public float getWeight() {
        return 50;
    }
}
