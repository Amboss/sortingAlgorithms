package sortingAlgorithms.algorithms;

import java.util.List;

/**
 * Interface for sorting algorithms;
 */
public interface SortingAlgorithm {

    /**
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    public List<Integer> sort(List<Integer> list);
}
