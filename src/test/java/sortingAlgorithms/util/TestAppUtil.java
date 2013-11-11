package sortingAlgorithms.util;

import org.junit.Test;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Testing application utility
 */
public class TestAppUtil {

    private AppUtil appUtil = new AppUtilImpl();

    /**
     * Testing getRandomNumbers() method
     */
    @Test
    public void test_getRandomNumbers() {

        Integer amount = 10;
        Integer maxRange = 10;

        // creating list with specified amount of random numbers
        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        assertEquals("FAIL - list size must be same,", (Object) amount, list.size());
    }
}
