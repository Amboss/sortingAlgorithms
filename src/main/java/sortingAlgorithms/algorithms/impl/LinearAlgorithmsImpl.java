package sortingAlgorithms.algorithms.impl;

import sortingAlgorithms.algorithms.LinearAlgorithms;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.Arrays;
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
     * @throws RuntimeException
     * @return List<Integer>
     */
    @Override
    public List<Integer> getHeapSorting(List<Integer> list) throws RuntimeException {

        // checking input parameter for null
        if (list == null) {
            throw new RuntimeException("ArrayList not specified!");
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
     * @param list - contain array with unsorted integer values.
     *             Lowest value of algorithm set to 0.
     * @throws RuntimeException
     * @return List<Integer>
     */
    @Override
    public List<Integer> getQuickSorting(List<Integer> list) throws RuntimeException{

        // checking input parameter for null
        if (list == null) {
            throw new RuntimeException("Disallowed value");
        }

        int low = 0;
        //low = list.indexOf(Collections.min(list));  TODO oO WTF ????

        return sortPartition(list, low, list.size() - 1);
    }

    /*
     * sorting partition for getQuickSorting()
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

    /**
     * RadixSort
     *
     * @param list - contain array with unsorted integer values;
     * @throws RuntimeException
     * @return List<Integer>
     */
    @Override
    @SuppressWarnings("unchecked")
    public List<Integer> getRadixSorting(List<Integer> list) throws RuntimeException{

        // checking input parameter for null
        if (list == null) {
            throw new RuntimeException("ArrayList not specified!");
        }


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
     * @throws RuntimeException
     * @return List<Integer>
     */
    @Override
    public List<Integer> getMergeSorting(List<Integer> list) throws RuntimeException{

        // checking input parameter for null
        if (list == null) {
            throw new RuntimeException("ArrayList not specified!");
        }

        // converting to array
        Integer[] numbers = new Integer[list.size()];
        list.toArray(numbers);

        Integer number = list.size();

        return processArrays(0, number - 1, numbers, new Integer[number]);
    }

    /*
     * recursively sorted via the Merge sort algorithm for getMergeSorting()
     * @param numbers - target array
     * @param helper - second part of array (left side of the array)
     * @param low  - lowest value of list
     * @param high - highest value of list
     */
    private List<Integer> processArrays(int low, int high, Integer[] numbers, Integer[] helper) {

        // checking input parameter for null
        if (numbers == null || helper == null) {
            return null;
        }

        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            processArrays(low, middle, numbers, helper);
            // Sort the right side of the array
            processArrays(middle + 1, high, numbers, helper);

            /*
             * Merging both arrays.
             */
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
        }
        return new ArrayList<>(Arrays.asList(numbers));
    }
}
