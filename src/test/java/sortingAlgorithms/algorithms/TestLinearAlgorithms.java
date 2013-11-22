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
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Linear Algorithms
 */
public class TestLinearAlgorithms {

    private static AppUtil appUtil = null;

    private static List<Integer> sortedList = null;

    private static List<Integer> testedList = null;

    private static int amount = 20;

    private static int maxRange = 50;

    @BeforeClass
    public static void initList() {
        appUtil = new AppUtilImpl();
        testedList = appUtil.getRandomNumbers(amount, maxRange);
        sortedList = new ArrayList<Integer>(testedList);
        Collections.sort(sortedList);
    }

    /**
     * Testing Heap sort method
     */
    @Test
    public void test_getHeapSorting() {

        SortingAlgorithm algorithm = new HeapSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing Quick sort method
     */
    @Test
    public void test_getQuickSorting() {

        SortingAlgorithm algorithm = new QuickSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing Radix sort method
     */
    @Test
    public void test_getRadixSorting() {

        SortingAlgorithm algorithm = new RadixSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing MergeSort  method
     */
    @Test
    public void test_getMergeSorting() {

        SortingAlgorithm algorithm = new MergeSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }
}
