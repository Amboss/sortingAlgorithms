package sortingAlgorithms.algoritms;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algoritms.impl.QuadraticAlgorithmsImpl;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Testing Quadratic Algorithms.
 */
public class TestQuadraticAlgorithms {

    private QuadraticAlgorithms quadraticAlgorithms = new QuadraticAlgorithmsImpl();

    private AppUtil appUtil = new AppUtilImpl();

    private static ArrayList<Integer> listToMatch = new ArrayList<>();

    @BeforeClass
    public static void initList() {
        for (int i = 0; i < 20; i++) {
            listToMatch.add(i, i);
        }
    }

    /**
     * Testing getSelectionSorting() method.
     */
    @Test
    public void test_getSelectionSorting() {

        ArrayList<Integer> list = appUtil.getRandomNumbers(20, 20);
        list = quadraticAlgorithms.getSelectionSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getBubbleSorting() method.
     */
    @Test
    public void test_getBubbleSorting() {

        ArrayList<Integer> list = appUtil.getRandomNumbers(20, 20);
        list = quadraticAlgorithms.getBubbleSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getInsertSorting() method.
     */
    @Test
    public void test_getInsertSorting() {

        ArrayList<Integer> list = appUtil.getRandomNumbers(20, 20);
        list = quadraticAlgorithms.getInsertSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }

    /**
     * Testing getShellSorting() method.
     */
    @Test
    public void test_getShellSorting() {

        ArrayList<Integer> list = appUtil.getRandomNumbers(20, 20);
        list = quadraticAlgorithms.getShellSorting(list);

        assertEquals("FAIL - list must be same,", listToMatch, list);
    }
}
