package PART3;

public class Laser extends Accessory {
    Suit suit;

    public Laser(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String getDescription() {
        return suit.getDescription() + " with Laser";
    }

    /**
     * Returns cost of the Laser with the cost of the remaining suit.
     * @return cost of the Laser + cost of the suit
     */
    @Override
    public float getCost() {
        return 200 + suit.getCost();
    }

    /**
     * Returns weight of the Laser with the weight of the remaining suit
     * @return weight of the Laser + weight of the suit
     */
    @Override
    public float getWeight() {
        return (float) (5.5 + suit.getWeight());
    }
}
