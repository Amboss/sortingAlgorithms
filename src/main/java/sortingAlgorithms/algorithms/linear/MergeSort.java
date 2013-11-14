package sortingAlgorithms.algorithms.linear;

import sortingAlgorithms.algorithms.SortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * MergeSort - Sortable sequence consisting of n elements is divided into two smaller sequences.
 * Recursively sort each of the sequences obtained in the same manner. When the two smaller sorted
 * sequences, merge, alternately choosing from them the smallest term.
 * [http://vie2004.blogspot.com/2011/12/blog-post.html#]
 * <p/>
 * Advantages: the algorithm is effective in a large amount of input array (more than 1000).
 */
public class MergeSort implements SortingAlgorithm {

    // target array
    private Integer[] numbers;

    // second part of array (left side of the array)
    private Integer[] helper;

    /**
     * @param list - contain array with unsorted integer values.
     * @return List<Integer>
     * @throws IllegalArgumentException
     */
    @Override
    public List<Integer> sort(List<Integer> list) {

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("ArrayList not specified!");
        }

        // converting to array
        numbers = new Integer[list.size()];
        list.toArray(numbers);

        int number = list.size();

        helper = new Integer[number];

        return processArrays(0, number - 1);
    }

    /*
     * recursively sorted via the Merge sort algorithm for getMergeSorting()
     * @param numbers - target array
     * @param helper - second part of array (left side of the array)
     * @param low  - lowest value of list
     * @param high - highest value of list
     */
    private List<Integer> processArrays(int low, int high) {

        // checking input parameter for null
        if (numbers == null || helper == null) {
            return null;
        }

        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;

            // Sort the left side of the array
            processArrays(low, middle);

            // Sort the right side of the array
            processArrays(middle + 1, high);

            // Merging both arrays
            numbers = mergeArrays(low, high, middle);
        }
        return new ArrayList<>(Arrays.asList(numbers));
    }

    /*
     * Merging both arrays.
     */
    private Integer[] mergeArrays(int low, int high, int middle) {

        // Copy both parts into the helper array
        System.arraycopy(numbers, low, helper, low, high + 1 - low);

        int i = low;

        int j = middle + 1;

        int k = low;

        // Copy the smallest values from either the left or the right side back to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }
        return numbers;
    }
}
