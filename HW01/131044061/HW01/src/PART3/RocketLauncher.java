package PART3;

public class RocketLauncher extends Accessory {
    Suit suit;

    public RocketLauncher(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String getDescription() {
        return suit.getDescription() + " with RocketLauncher";
    }

    /**
     * Returns cost of the RocketLauncher with the cost of the remaining suit.
     * @return cost of the RocketLauncher + cost of the suit
     */
    @Override
    public float getCost() {
        return 150 + suit.getCost();
    }

    /**
     * Returns weight of the RocketLauncher with the weight of the remaining suit
     * @return weight of the RocketLauncher + weight of the suit
     */
    @Override
    public float getWeight() {
        return (float) (7.5 + suit.getWeight());
    }
}
