package part2;

public class AntiClockWiseIterator implements Iterator{

    private final int[][] numbers;
    private int position_row = 0;
    private int position_column = 0;
    private int bound_south;
    private int bound_east;
    private int bound_north;
    private int bound_west;
    private Directions direction = Directions.SOUTH;
    enum Directions{
        SOUTH,
        EAST,
        NORTH,
        WEST
    }

    public AntiClockWiseIterator(int[][] array2D){
        this.numbers = array2D;
        this.bound_west = 1;
        this.bound_east = array2D[0].length-1;
        this.bound_north = 0;
        this.bound_south = array2D.length-1;
    }

    public int get_current(){
        return numbers[position_row][position_column];
    }

    @Override
    public boolean hasNext() {
        switch (this.direction){
            case SOUTH:
                if (position_row < bound_south)
                    return true;
                break;
            case EAST:
                if (position_column < bound_east)
                    return true;
                break;
            case NORTH:
                if (position_row > bound_north)
                    return true;
                break;
            case WEST:
                if (position_column > bound_west)
                    return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()){
            switch (this.direction){
                case SOUTH:
                    this.position_row++;
                    if (this.position_row == bound_south){
                        this.direction = Directions.EAST;
                        bound_south--;
                    }
                    return this.numbers[this.position_row][this.position_column];
                case EAST:
                    this.position_column++;
                    if (this.position_column == bound_east){
                        this.direction = Directions.NORTH;
                        bound_east--;
                    }
                    return this.numbers[this.position_row][this.position_column];
                case NORTH:
                    this.position_row--;
                    if (position_row == bound_north){
                        this.direction = Directions.WEST;
                        bound_north++;
                    }
                    return this.numbers[this.position_row][this.position_column];
                case WEST:
                    this.position_column--;
                    if (position_column == bound_west){
                        this.direction = Directions.SOUTH;
                        bound_west++;
                    }
                    return this.numbers[this.position_row][this.position_column];
            }
        }
        return null;
    }
}
