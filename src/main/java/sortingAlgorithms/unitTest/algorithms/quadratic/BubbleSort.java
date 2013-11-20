package sortingAlgorithms.unitTest.algorithms.quadratic;

import sortingAlgorithms.unitTest.algorithms.SortingAlgorithm;
import sortingAlgorithms.unitTest.util.AppUtil;
import sortingAlgorithms.unitTest.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Bubble sort - is a Quadratic, simple sorting algorithm that works by repeatedly stepping through the list
 * to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong
 * order. The pass through the list is repeated until no swaps are needed, which indicates that the
 * list is sorted. The algorithm gets its name from the way smaller elements "bubble" to the top of
 * the list. Because it only uses comparisons to operate on elements, it is a comparison sort.
 * Although the algorithm is simple, most of the other sorting algorithms are more efficient for
 * large lists. [http://en.wikipedia.org/wiki/Bubble_Sort]
 *
 * Disadvantages: not effective on a large amount of input array (more than 100).
 */
public class BubbleSort implements SortingAlgorithm {

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

        // moving forward through array.
        for (int i = list.size() - 1; i >= 2; i--) {

            boolean sorted = true;

            // set the correct order between near elements.
            for (int j = 0; j < i; j++) {

                // swap places if the order of  elements are not correct and mark swap.
                if (list.get(j) > list.get(j + 1)) {
                    appUtil.swap(list, j, j + 1);
                    sorted = false;
                }
            }
            // stop if no changes was made.
            if (sorted) {
                break;
            }
        }
        return list;
    }

}
