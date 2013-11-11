package sortingAlgorithms.algoritms.linear;

import sortingAlgorithms.algoritms.LinearAlgorithms;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Linear algorithms.
 */
public class LinearAlgorithmsImpl implements LinearAlgorithms {

    AppUtil appUtil = new AppUtilImpl();

    /**
     * HeapSort
     *
     * @param list - contain array with unsorted integer values;
     * @return List<Integer>
     */
    @Override
    public List<Integer> getHeapSorting(List<Integer> list) {

        assert list != null : "arrayList not specified!";

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
     * @return List<Integer>
     */
    @Override
    public List<Integer> getQuickSorting(List<Integer> list) {

        assert list != null : "arrayList not specified!";
        return sortPartition(list, 0, list.size() - 1);
    }

    /*
     * sorting partition for QuickSort
     * @param list - contain array with processed values
     * @param
     * @param
     */
    private List<Integer> sortPartition(List<Integer> list, int low, int high) {

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
     * @return List<Integer>
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Integer> getRadixSorting(List<Integer> list) {

        assert list != null : "arrayList not specified!";

        // To get a digit we can first divide number with 10^i and then get the remainder
        // after dividing by 10, where i = 0 to 2*Number of digits in N;
        int exp = 1;

        // the number of digits in N^2 can be maximum double of the digits in N
        int maxDigits = 2;

        for (int i = 0; i < maxDigits; i++) {

            // initiating multidimensional list of lists of size 10
            List[] bucketList = new ArrayList[10];
            for (int k = 0; k < 10; k++) {
                bucketList[k] = new ArrayList<>();
            }
            for (Integer aList : list) {
                int number = (aList / exp) % 10;
                bucketList[number].add(aList); // producing warning: unchecked assignment - suppressed.
            }
            exp *= 10;
            int index = 0;
            for (int k = 0; k < 10; k++) {
                for (Object num : bucketList[k]) {
                    list.set(index, (Integer) num);
                    index++;
                }
            }
        }
        return list;
    }

    /**
     * MergeSort
     *
     * @param list - contain array with unsorted integer values;
     * @return List<Integer>
     */
    @Override
    public List<Integer> getMergeSorting(List<Integer> list) {

        assert list != null : "arrayList not specified!";

        return list;

    }
}
