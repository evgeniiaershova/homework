import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = createMatrix();
        orderMatrixByK(matrix);
    }

    /* Упорядочить строки матрицы в порядке возрастания значений элементов k-го столбца.*/

    private static void orderMatrixByK(int [][] matrix) {

        System.out.println("Enter the index of the column. It should be an integer in the range between " + 0 + " and " + (matrix.length - 1));
        int k = scanner.nextInt();

        for (int row = 0; row < matrix.length - 1; row ++ ) {
            int[] currentMinRow = matrix[row];
            int currentMinIndex = row;

            for (int j = row +1; j < matrix.length; j++) {
                if (currentMinRow[k] > matrix[j][k]) {
                    currentMinRow = matrix[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != row) {
                matrix[currentMinIndex] = matrix[row];
                matrix[row] = currentMinRow;
            }
        }

        System.out.println("Sorted matrix");
        printArray(matrix);
    }

    private static int[][] createMatrix() {

        System.out.println("Enter an integer to set the size of the matrix: ");
        int size = scanner.nextInt();
        int[][] matrix = new int[size][size];

        Random generator = new Random();
        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
                matrix[row][column] = generator.nextInt(size + size + 1 ) - size;
            }
        }

        System.out.println("Unsorted matrix");
        printArray(matrix);
        return matrix;
    }

    public static void printArray(int matrix[][]) {
        for (int[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

}
