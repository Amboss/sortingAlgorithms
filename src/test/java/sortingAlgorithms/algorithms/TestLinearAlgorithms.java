package sortingAlgorithms.algorithms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algorithms.linear.HeapSort;
import sortingAlgorithms.algorithms.linear.MergeSort;
import sortingAlgorithms.algorithms.linear.QuickSort;
import sortingAlgorithms.algorithms.linear.RadixSort;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Linear Algorithms
 */
public class TestLinearAlgorithms {

    private AppUtil appUtil = new AppUtilImpl();

    private static ArrayList<Integer> listToMatch = new ArrayList<Integer>();

    private static int amount = 20;

    // range of numbers equals to amount to be able make a assert
    private static int maxRange = amount;

    @BeforeClass
    public static void initList() {
        for (int i = 0; i < amount; i++) {
            listToMatch.add(i, i);
        }
    }

    /**
     * Testing Heap sort method
     */
    @Test
    public void test_getHeapSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new HeapSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing Quick sort method
     */
    @Test
    public void test_getQuickSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new QuickSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing Radix sort method
     */
    @Test
    public void test_getRadixSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new RadixSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing MergeSort  method
     */
    @Test
    public void test_getMergeSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new MergeSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }
}
