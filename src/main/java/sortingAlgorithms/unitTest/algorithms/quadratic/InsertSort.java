package sortingAlgorithms.unitTest.algorithms.quadratic;

import sortingAlgorithms.unitTest.algorithms.SortingAlgorithm;
import sortingAlgorithms.unitTest.util.AppUtil;
import sortingAlgorithms.unitTest.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one
 * item at a time. It is much less efficient on large lists than more advanced algorithms such as
 * quick sort, heap sort, or merge sort. However, insertion sort provides several advantages:
 * - Simple implementation,
 * - Efficient for (quite) small data sets,
 * - Adaptive (i.e., efficient) for data sets that are already substantially sorted: the time
 *      complexity is O(n + d), where d is the number of inversions,
 * - More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as
 *      selection sort or bubble sort; the best case (nearly sorted input) is O(n),
 * - Stable; i.e., does not change the relative order of elements with equal keys,
 * - In-place; i.e., only requires a constant amount O(1) of additional memory space,
 * - Online; i.e., can sort a list as it receives it. [http://en.wikipedia.org/wiki/Insert_sort]
 */
public class InsertSort implements SortingAlgorithm {

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
            throw new IllegalArgumentException("ArrayList not specified!");
        }

        int i, j;

        // moving forward through array.
        for (i = 1; i < list.size(); i++) {
            j = i;

            // moving element back, while element bigger than others.
            while (j > 0 && list.get(j - 1) > list.get(j)) {
                appUtil.swap(list, j, j - 1);
                j--;
            }
        }
        return list;
    }
}
