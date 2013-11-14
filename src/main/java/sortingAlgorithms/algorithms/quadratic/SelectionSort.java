package sortingAlgorithms.algorithms.quadratic;

import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Selection sort - is a Quadratic sorting algorithm, specifically an in-place comparison sort. The basic
 * idea is to look at each element in the array, and for each element look at all remaining elements
 * to see if there is something smaller that should be in this position. If there is, exchange the
 * two values. [http://www.leepoint.net/notes-java/data/arrays/31arrayselectionsort.html]
 */
public class SelectionSort implements SortingAlgorithm{

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

        // moving forward through array
        for (int i = 0; i < list.size() - 1; i++) {

            // look at all remaining elements to see if there is something smaller
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) > list.get(j)) {
                    // exchange the two values if there is
                    appUtil.swap(list, i, j);
                }
            }
        }
        return list;
    }
}
