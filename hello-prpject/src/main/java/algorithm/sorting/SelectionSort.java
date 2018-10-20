package algorithm.sorting;

/**
 * Sorting an array with selection sort.
 */
import java.security.SecureRandom;
import java.util.Arrays;

public class SelectionSort {

    /**
     * sort array using selection sort
     * @param data
     */
    public static void selectionSort(int[] data) {
        // loop over data.length - 1 elements
        for (int i = 0; i < data.length - 1; i++) {
            // first index of remaining array
            int smallest = i;

            // loop to find index of smallest element
            for (int index = i + 1; index < data.length; index++) {
                if (data[index] < data[smallest]) {
                    smallest = index;
                }
            }

            // swap smallest element into position
            swap(data, i, smallest);
            // output pass of algorithm
            printPass(data, i + 1, smallest);
        }
    } // end method selectionSort

    /**
     * helper method to swap values in two elements
     * @param data
     * @param first
     * @param second
     */
    private static void swap(int[] data, int first, int second) {
        // store first in temporary
        int temporary = data[first];
        // replace first with second
        data[first] = data[second];
        // put temporary in second
        data[second] = temporary;
    }

    /**
     * print a pass of the algorithm
     * @param data
     * @param pass
     * @param index
     */
    private static void printPass(int[] data, int pass, int index) {
        System.out.printf("after pass %2d: ", pass);

        // output elements till selected item
        for (int i = 0; i < index; i++) {
            System.out.printf("%d  ", data[i]);
        }

        // indicate swap
        System.out.printf("%d* ", data[index]);

        // finish outputting array
        for (int i = index + 1; i < data.length; i++) {
            System.out.printf("%d  ", data[i]);
        }

        // for alignment
        System.out.printf("%n            ");

        // indicate amount of array that’s sorted
        for (int j = 0; j < pass; j++) {
            System.out.print("--  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SecureRandom generator = new SecureRandom();

        // create array
        int[] data = new int[10];

        // populate array
        for (int i = 0; i < data.length; i++) {
            data[i] = 10 + generator.nextInt(90);
        }

        // display array
        System.out.printf("Unsorted array:%n%s%n%n", Arrays.toString(data));
        // sort array
        selectionSort(data);

        // display array
        System.out.printf("Sorted array:%n%s%n%n", Arrays.toString(data));
    }
} // end class SelectionSortTest