package sortingAlgorithms.util;

import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing application utility
 */
public class TestAppUtil {

    private static AppUtil appUtil = null;

    /**
     * Initialisation
     */
    @BeforeClass
    public static void initExperiment() {
        appUtil = new AppUtilImpl();
    }

    /**
     * Testing getRandomNumbers() method
     */
    @Test
    public void test_getRandomNumbers() {

        int amount = 10;
        int maxRange = 10;

        // creating list with specified amount of random numbers
        List<Integer> list = appUtil.getRandomNumbers(amount, maxRange);

        assertEquals("FAIL - list size must be same,", (Object) amount, list.size());
    }

    /**
     * Testing swap() method
     */
    @Test
    public void test_swap() {

        List<Integer> list = new ArrayList<Integer>();
        list.add(0, 222);
        list.add(1, 55);

        // swapping numbers
        appUtil.swap(list, 1, 0);

        assertEquals("FAIL - numbers have to be equal", (Object) 55, list.get(0));
    }

    /**
     * Testing loadArrayFromFile() method
     */
    @Test
    public void test_loadArrayFromFile() {

        String filePath = "test.txt";

        // creating list with specified amount of random numbers
        List<Integer> list = appUtil.getRandomNumbers(10, 10);
        appUtil.saveArrayToFile(filePath, list);

        // testing content of file
        List<Integer> list2 = appUtil.loadArrayFromFile(filePath);
        assertEquals("Fail - file must contain same digits", list, list2);

        // deleting testing file
        File myFile = new File(filePath);
        if (myFile.exists()) {
            myFile.delete();
        }
    }

    /**
     * Testing saveArrayToFile() method
     */
    @Test
    public void test_saveArrayToFile() {

        String filePath = "testFile.txt";

        // creating list with specified amount of random numbers
        List<Integer> list = appUtil.getRandomNumbers(10, 10);
        appUtil.saveArrayToFile(filePath, list);

        // testing existence of file
        File file = new File(filePath);
        assertTrue("Fail - file test.text must be created", file.exists());

        // testing content of file
        List<Integer> list2 = appUtil.loadArrayFromFile(filePath);
        assertEquals("Fail - file must contain same digits", list, list2);

        // deleting testing file
        File myFile = new File(filePath);
        if (myFile.exists()) {
            myFile.delete();
        }
    }
}
