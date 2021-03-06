package sortingAlgorithms.algorithms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algorithms.quadratic.BubbleSort;
import sortingAlgorithms.algorithms.quadratic.InsertSort;
import sortingAlgorithms.algorithms.quadratic.SelectionSort;
import sortingAlgorithms.algorithms.quadratic.ShellSort;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Quadratic Algorithms.
 */
public class TestQuadraticAlgorithms {

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
     * Testing getSelectionSorting() method.
     */
    @Test
    public void test_getSelectionSorting() {

        SortingAlgorithm algorithm = new SelectionSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing getBubbleSorting() method.
     */
    @Test
    public void test_getBubbleSorting() {

        SortingAlgorithm algorithm = new BubbleSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing getInsertSorting() method.
     */
    @Test
    public void test_getInsertSorting() {

        SortingAlgorithm algorithm = new InsertSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }

    /**
     * Testing getShellSorting() method.
     */
    @Test
    public void test_getShellSorting() {

        SortingAlgorithm algorithm = new ShellSort();
        assertEquals("FAIL - list must be same,", sortedList, algorithm.sort(testedList));
    }
}
