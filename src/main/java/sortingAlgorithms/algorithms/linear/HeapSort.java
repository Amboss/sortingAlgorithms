package sortingAlgorithms.algorithms.linear;

import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Heap sort - is a Linear comparison-based sorting algorithm to create a sorted array (or list), and is part
 * of the selection sort family. Although somewhat slower in practice on most machines than a
 * well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n)
 * runtime. Heapsort is an in-place algorithm, but it is not a stable sort.
 * [http://en.wikipedia.org/wiki/HeapSort]
 */
public class HeapSort implements SortingAlgorithm {

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

        // building heap
        for (int child = 1; child < list.size(); child++) {
            int parent = (child - 1) / 2;

            // swap child & parent if parent < child
            while (parent >= 0 && list.get(parent).compareTo(list.get(child)) < 0) {
                appUtil.swap(list, parent, child);
                child = parent;
                parent = (child - 1) / 2;
            }
        }
        return shrinkHeap(list);
    }

    /*
     * shrinking of Heap
     * @param list - contain array that must be reduced.
     */
    private List<Integer> shrinkHeap(List<Integer> list) {

        for (int n = list.size() - 1; n >= 0; n--) {

            appUtil.swap(list, 0, n);
            int parent = 0;

            while (true) {
                int leftChild = 2 * parent + 1;

                if (leftChild >= n) break;

                int rightChild = leftChild + 1;

                int maxChild = leftChild;

                if (rightChild < n && list.get(leftChild).compareTo(list.get(rightChild)) < 0)
                    maxChild = rightChild;

                // swap child & parent if parent < child
                if (list.get(parent).compareTo(list.get(maxChild)) < 0) {
                    appUtil.swap(list, parent, maxChild);
                    parent = maxChild;
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
