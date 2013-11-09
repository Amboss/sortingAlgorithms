package sortingAlgorithms.algoritms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algoritms.impl.LinearAlgorithmsImpl;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;

/**
 * Testing Linear Algorithms
 */
public class TestLinearAlgorithms {

    private LinearAlgorithms linearAlgorithms = new LinearAlgorithmsImpl();

    private AppUtil appUtil = new AppUtilImpl();

    private static ArrayList<Integer> listToMatch = new ArrayList<>();

    @BeforeClass
    public static void initList() {
        for (int i = 0; i < 20; i++) {
            listToMatch.add(i, i);
        }
    }

    /**
     * Testing Heap sort method
     */
    @Test
    public void test_getHeapSorting() {

    }

    /**
     * Testing Quick sort method
     */
    @Test
    public void test_getQuickSorting() {

    }

    /**
     * Testing Radix sort method
     */
    @Test
    public void test_getRadixSorting() {

    }

    /**
     * Testing MergeSort  method
     */
    @Test
    public void test_getMergeSorting() {

    }
}
