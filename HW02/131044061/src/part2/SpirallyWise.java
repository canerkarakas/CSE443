package part2;

public class SpirallyWise {
    private final int[][] numbers;
    AntiClockWiseIterator antiClockWiseIterator = null;
    private int choice_direction = 0; /* anti clock wise or clock wise*/

    public SpirallyWise(int[][] numbers) {
        this.numbers = numbers;
    }

    public SpirallyWise(int[][] numbers, int choice_direction) {
        this.numbers = numbers;
        this.choice_direction = choice_direction;
    }

    public int get_current_number(){
        return antiClockWiseIterator.get_current();
    }

    public int get_number(int row, int column){
        return numbers[row][column];
    }

    public void setChoice_direction(int choice_direction) {
        this.choice_direction = choice_direction;
    }

    public int getChoice_direction() {
        return choice_direction;
    }

    public void show_numbers(){
        if(choice_direction == 0) {
            if (antiClockWiseIterator == null)
                antiClockWiseIterator = new AntiClockWiseIterator(this.numbers);
            System.out.print("show all numbers : ");
            System.out.print(numbers[0][0] + " ");
            while (antiClockWiseIterator.hasNext())
                System.out.print(antiClockWiseIterator.next() + " ");
            System.out.println();
        }
    }

    public Iterator createIterator(){
        if (choice_direction == 0){
            antiClockWiseIterator = new AntiClockWiseIterator(this.numbers);
            return antiClockWiseIterator;
        }
        return null;
    }
}
