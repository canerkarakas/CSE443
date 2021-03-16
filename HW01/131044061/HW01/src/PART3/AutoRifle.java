package PART3;

public class AutoRifle extends Accessory {
    Suit suit;

    public AutoRifle(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String getDescription() {
        return suit.getDescription() + " with AutoRifle";
    }

    /**
     * Returns cost of the AutoRifle with the cost of the remaining suit.
     * @return cost of the AutoRifle + cost of the suit
     */
    @Override
    public float getCost() {
        return 30 + suit.getCost();
    }

    /**
     * Returns weight of the AutoRifle with the weight of the remaining suit
     * @return weight of the AutoRifle + weight of the suit
     */
    @Override
    public float getWeight() {
        return (float) (1.5 + suit.getWeight());
    }
}
