package PART3;

public class Flamethrower extends Accessory {
    Suit suit;

    public Flamethrower(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String getDescription() {
        return suit.getDescription() + " with Flamethrower";
    }

    /**
     * Returns cost of the flamethrower with the cost of the remaining suit.
     * @return cost of the flamethrower + cost of the suit
     */
    @Override
    public float getCost() {
        return 50 + suit.getCost();
    }

    /**
     * Returns weight of the flamethrower with the weight of the remaining suit
     * @return weight of the flamethrower + weight of the suit
     */
    @Override
    public float getWeight() {
        return 2 + suit.getWeight();
    }

}
