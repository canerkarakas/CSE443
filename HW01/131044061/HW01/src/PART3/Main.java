package PART3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        Suit suit = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("1-Dec 2-Ora 3-Tor");
        System.out.println("Please choose a main suit(1-2-3): ");
        int mainSuit = scanner.nextInt();

        switch (mainSuit) {
            case 1 -> suit = new Dec();
            case 2 -> suit = new Ora();
            case 3 -> suit = new Tor();
            default -> {
                System.out.println("Error while choosing main suit, exiting");
                System.exit(1);
            }
        }

        System.out.println("1-Flamethrower 2-AutoRifle 3-RocketLauncher 4-Laser");
        int accessory;
        System.out.println("Please choose an accessory(1/2/3/4 or any other number to finish order): ");
        do {
            accessory = scanner.nextInt();
            switch (accessory) {
                case 1:
                    suit = new Flamethrower(suit);
                    break;
                case 2:
                    suit = new AutoRifle(suit);
                    break;
                case 3:
                    suit = new RocketLauncher(suit);
                    break;
                case 4:
                    suit = new Laser(suit);
                    break;
                default:
                    break;
            }
        } while (accessory >= 1 && accessory <=4);
        System.out.println("Finished accessory selection.");
        System.out.println("You ordered " + suit.getDescription() + ".");
        System.out.println("Total cost: " + suit.getCost() + ".");
        System.out.println("Total weight: " + suit.getWeight() + ".");
    }
}
