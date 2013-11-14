package sortingAlgorithms.algorithms.quadratic;

import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Shell sort - is an in-place comparison Quadratic sort. It generalizes an exchanging sort, such as insertion
 * or bubble sort, by starting the comparison and exchange of elements with elements that are far
 * apart before finishing with neighboring elements. Starting with far apart elements can move some
 * out-of-place elements into position faster than a simple nearest neighbor exchange.
 * [http://en.wikipedia.org/wiki/Shellsort]
 */
public class ShellSort implements SortingAlgorithm {

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

        int i, j, increment, temp, arraySize = list.size();

        // moving forward through array.
        for (increment = arraySize / 2; increment > 0; increment /= 2) {

            for (i = increment; i < arraySize; i++) {
                temp = list.get(i);
                for (j = i; j >= increment; j -= increment) {
                    // comparing distant elements
                    if (temp < list.get(j - increment)) {
                        list.set(j, list.get(j - increment));
                    } else {
                        break;
                    }
                }
                list.set(j, temp);
            }
        }
        return list;
    }
}
