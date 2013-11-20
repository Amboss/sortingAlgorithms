package sortingAlgorithms.unitTest.algorithms.linear;

import sortingAlgorithms.unitTest.algorithms.SortingAlgorithm;
import sortingAlgorithms.unitTest.util.AppUtil;
import sortingAlgorithms.unitTest.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Quick sort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on
 * average, makes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2)
 * comparisons, though this behavior is rare. Quicksort is often faster in practice than other
 * O(n log n) algorithms.[1] Additionally, quicksort's sequential and localized memory references
 * work well with a cache. Quicksort is a comparison sort and, in efficient implementations, is not
 * a stable sort. [http://en.wikipedia.org/wiki/QuickSort]
 */
public class QuickSort implements SortingAlgorithm {

    AppUtil appUtil = new AppUtilImpl();

    /**
     * @param list - contain array with unsorted integer values.
     * @throws IllegalArgumentException
     * @return List<Integer>
     */
    @Override
    public List<Integer> sort(List<Integer> list) {

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("Disallowed value");
        }

        int low = 0;

        return sortPartition(list, low, list.size() - 1);
    }

    /*
     * sorting partition
     * @param list - contain array with processed values
     * @param low  - lowest value of list
     * @param high - highest value of list
     */
    private List<Integer> sortPartition(List<Integer> list, int low, int high) {

        // checking input parameter for null
        if (list == null) {
            return list;
        }

        int i = low, j = high;

        // Get the pivot element from the middle of the list
        int pivot = list.get(low + (high - low) / 2);

        // Divide into two lists
        while (i <= j) {
            // get the next element from the left if left list is smaller then the pivot
            while (list.get(i) < pivot) {
                i++;
            }

            // get the next element from right list if value from the right list is larger
            while (list.get(j) > pivot) {
                j--;
            }

            // swap if value found in the right list
            if (i <= j) {
                appUtil.swap(list, i, j);
                i++;
                j--;
            }
        }

        // Recursion
        if (low < j) sortPartition(list, low, j);
        if (i < high) sortPartition(list, i, high);
        return list;
    }
}
