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
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Quadratic Algorithms.
 */
public class TestQuadraticAlgorithms {

    private AppUtil appUtil = new AppUtilImpl();

    private static List<Integer> listToMatch = new ArrayList<Integer>();

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
     * Testing getSelectionSorting() method.
     */
    @Test
    public void test_getSelectionSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new SelectionSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getBubbleSorting() method.
     */
    @Test
    public void test_getBubbleSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new BubbleSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getInsertSorting() method.
     */
    @Test
    public void test_getInsertSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new InsertSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getShellSorting() method.
     */
    @Test
    public void test_getShellSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        SortingAlgorithm algorithm = new ShellSort();

        list = algorithm.sort(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }
}
