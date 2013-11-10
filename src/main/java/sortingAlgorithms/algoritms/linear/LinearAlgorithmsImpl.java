package sortingAlgorithms.algoritms.linear;

import sortingAlgorithms.algoritms.LinearAlgorithms;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;

/**
 * Implementation of Linear algorithms.
 */
public class LinearAlgorithmsImpl implements LinearAlgorithms {

    AppUtil appUtil = new AppUtilImpl();

    /**
     * HeapSort
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getHeapSorting(ArrayList<Integer> list) {

        assert list != null && !list.equals(0) : "arrayList not specified or equals 0!";

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

        // shrinking Heap
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

    /**
     * QuickSort
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getQuickSorting(ArrayList<Integer> list) {

        assert list != null && !list.equals(0) : "arrayList not specified or equals 0!";
        return sortPartition(list, 0, list.size() - 1);
    }

    /**
     * sorting partition for QuickSort
     */
    private ArrayList<Integer> sortPartition(ArrayList<Integer> list, int low, int high) {

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

    /**
     * RadixSort
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getRadixSorting(ArrayList<Integer> list) {

        assert list != null && !list.equals(0) : "arrayList not specified or equals 0!";

        return list;
    }

    /**
     * MergeSort
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getMergeSorting(ArrayList<Integer> list) {

        assert list != null && !list.equals(0) : "arrayList not specified or equals 0!";

        return list;
    }
}
