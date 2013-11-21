package sortingAlgorithms.integrationTest;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.algorithms.linear.HeapSort;
import sortingAlgorithms.algorithms.linear.MergeSort;
import sortingAlgorithms.algorithms.linear.QuickSort;
import sortingAlgorithms.algorithms.linear.RadixSort;
import sortingAlgorithms.algorithms.quadratic.BubbleSort;
import sortingAlgorithms.algorithms.quadratic.InsertSort;
import sortingAlgorithms.algorithms.quadratic.SelectionSort;
import sortingAlgorithms.algorithms.quadratic.ShellSort;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Testing all involved classes
 */
public class TestAllFunctionality {

    private static AppUtil appUtil = new AppUtilImpl();

    private static List<SortingAlgorithm> algorithmList = null;

    private static List<Integer> randomNumbersList = null;

    private static List<Integer> sortedList = null;

    private static int amount = 10,  maxRange = 10;

    private static String filePath = "test.txt";

    private String sortedFilePath = "sortedTestFile.txt";

    /**
     * Initiating SortingAlgorithm implementation and add them to algorithmList
     */
    @BeforeClass
    public static void init_allAlgorithms() {

        algorithmList = new ArrayList<SortingAlgorithm>();

        // initiation of linear algorithms
        SortingAlgorithm heapSort = new HeapSort();
        algorithmList.add(heapSort);
        SortingAlgorithm mergeSort = new MergeSort();
        algorithmList.add(mergeSort);
        SortingAlgorithm quickSort = new QuickSort();
        algorithmList.add(quickSort);
        SortingAlgorithm radixSort = new RadixSort();
        algorithmList.add(radixSort);

        // initiation of quadratic algorithms
        SortingAlgorithm bubbleSort = new BubbleSort();
        algorithmList.add(bubbleSort);
        SortingAlgorithm insertSort = new InsertSort();
        algorithmList.add(insertSort);
        SortingAlgorithm selectSort = new SelectionSort();
        algorithmList.add(selectSort);
        SortingAlgorithm shellSort = new ShellSort();
        algorithmList.add(shellSort);

        // asserting algorithmList
        assertNotNull("Fail - list of algorithms can't be null", algorithmList);

        // asserting randomNumbersList
        randomNumbersList = appUtil.getRandomNumbers(amount, maxRange);
        assertEquals("FAIL - list size must be same,", (Object) amount, randomNumbersList.size());

        // asserting sortedList
        sortedList = new ArrayList<Integer>(randomNumbersList);
        //sortedList = randomNumbersList;
        Collections.sort(sortedList);
        assertNotNull("Fail - list of algorithms can't be null", sortedList);
        assertEquals("FAIL - list size must be same,", (Object) amount, sortedList.size());

        // creating file with random Numbers List
        appUtil.saveArrayToFile(filePath, randomNumbersList);

        // testing existence of file
        File file = new File(filePath);
        assertTrue("Fail - file test.text must be created", file.exists());

        // testing content of file
        List<Integer> list2 = appUtil.loadArrayFromFile(filePath);
        assertEquals("Fail - file must contain same digits", randomNumbersList, list2);
    }

    /**
     * Cleaning from tested file
     */
    @AfterClass
    public static void cleanUp() {

        // deleting testing file
        File myFile = new File(filePath);
        if (myFile.exists()) {
            myFile.delete();
        }
    }

    /**
     * Integration test for all algorithms
     */
    @Test
    public void test_allFunctionality() {

        File file = new File(filePath);

        if (file.exists()) {
            for (SortingAlgorithm algorithm: algorithmList) {

                // loading list from file and asserting target list
                List<Integer> unsortedListFormFile = appUtil.loadArrayFromFile(filePath);
                assertEquals("FAIL - list size must be same,", randomNumbersList, unsortedListFormFile);

                // sorting list and asserting for equal value
                List<Integer> sortedListFromFile = algorithm.sort(unsortedListFormFile);
                assertEquals("FAIL - list must contain same digits,", sortedList, sortedListFromFile);

                // saving testedList to new file
                appUtil.saveArrayToFile(sortedFilePath, sortedListFromFile);

                // asserting new file
                File testedFile = new File(sortedFilePath);
                assertTrue("Fail - file test.text must be created", testedFile.exists());

                // testing content of file
                List<Integer> list2 = appUtil.loadArrayFromFile(sortedFilePath);
                assertEquals("Fail - file must contain same digits", sortedList, list2);

                // deleting testing file
                File myFile = new File(sortedFilePath);
                if (myFile.exists()) {
                    myFile.delete();
                }
            }
        }
    }
}
