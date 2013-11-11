package sortingAlgorithms.algorithms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algorithms.quadratic.QuadraticAlgorithmsImpl;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing Quadratic Algorithms.
 */
public class TestQuadraticAlgorithms {

    private QuadraticAlgorithms quadraticAlgorithms = new QuadraticAlgorithmsImpl();

    private AppUtil appUtil = new AppUtilImpl();

    private static List<Integer> listToMatch = new ArrayList<>();

    private static Integer amount = 20;

    // range of numbers equals to amount to be able make a assert
    private static Integer maxRange = amount;

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
        list = quadraticAlgorithms.getSelectionSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getBubbleSorting() method.
     */
    @Test
    public void test_getBubbleSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);
        list = quadraticAlgorithms.getBubbleSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getInsertSorting() method.
     */
    @Test
    public void test_getInsertSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);
        list = quadraticAlgorithms.getInsertSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getShellSorting() method.
     */
    @Test
    public void test_getShellSorting() {

        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);
        list = quadraticAlgorithms.getShellSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }
}
