package PART3;

public abstract class Suit {
    String description = "Unknown description";

    public  String getDescription() {
        return description;
    }

    public abstract float getCost();

    public abstract float getWeight();

}
