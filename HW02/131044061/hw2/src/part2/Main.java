package part2;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test For Iterator : ");
        int[][] array2D = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        SpirallyWise spirallyWise = new SpirallyWise(array2D);
        Iterator iterator = spirallyWise.createIterator();
        System.out.print(spirallyWise.get_current_number() + " ");
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        System.out.println("New Test For Show Numbers New Array2D : ");
        int[][] array2D_2 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20}
        };
        SpirallyWise spirallyWise1 = new SpirallyWise(array2D_2, 0);
        spirallyWise1.show_numbers();
    }
}
