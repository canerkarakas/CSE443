package PART3;

public class Ora extends Suit {

    public Ora() {
        description = "Ora";
    }


    @Override
    public float getCost() {
        return 1500;
    }

    @Override
    public float getWeight() {
        return 30;
    }
}
