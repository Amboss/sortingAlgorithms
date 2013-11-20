package sortingAlgorithms.unitTest.algorithms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.unitTest.algorithms.linear.HeapSort;
import sortingAlgorithms.unitTest.algorithms.linear.MergeSort;
import sortingAlgorithms.unitTest.algorithms.linear.QuickSort;
import sortingAlgorithms.unitTest.algorithms.linear.RadixSort;
import sortingAlgorithms.unitTest.util.AppUtil;
import sortingAlgorithms.unitTest.util.impl.AppUtilImpl;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Linear Algorithms
 */
public class TestLinearAlgorithms {

    private static AppUtil appUtil = new AppUtilImpl();

    private static List<Integer> sortedList = null;

    private static List<Integer> testedList = null;

    private static int amount = 20;

    private static int maxRange = 50;

    @BeforeClass
    public static void initList() {
        testedList = appUtil.getRandomNumbers(amount, maxRange);
        sortedList = testedList;
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
