package sortingAlgorithms.experiment;

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
import sortingAlgorithms.experiment.impl.Experiment;
import sortingAlgorithms.util.AppTimer;
import sortingAlgorithms.util.impl.Timer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Testing functionality of Experiment
 */
public class TestExperiment {

    private static Experiment ex = null;

    private static AppTimer appTimer = null;

    /**
     * Initialisation
     */
    @BeforeClass
    public static void initExperiment() {
        ex = new Experiment();
        appTimer = new Timer();
    }

    /**
     * Testing pause
     */
    @Test
    public void test_setPause() {

        appTimer.start();
        ex.setPause(2);
        appTimer.stop();
        assertTrue("Fail - period of time must be same",
                appTimer.getTotalTime() >= 2000 && appTimer.getTotalTime() < 2002);
    }

    /**
     * Testing output of average value
     */
    @Test
    public void test_getAverageStatistical() {

        List<Long> standardList = new ArrayList<Long>();

        long foo = 0;

        // filling list with values
        for (int i = 0; i <= 100; i++) {
            standardList.add((long) 5);
        }

        // calculating average value
        for (Long bar : standardList) {
            foo += bar;
        }
        Long standardAverage = foo / standardList.size();

        assertEquals("Fail - average values must be same", standardAverage, ex.getAverageStatistical(standardList));
    }

    /**
     * Testing initialisation of all algorithms
     */
    @Test
    public void test_initAllAlgorithms() {

        List<SortingAlgorithm> algorithmList = new ArrayList<SortingAlgorithm>();

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

        List<SortingAlgorithm> testedList = ex.initAllAlgorithms();
        assertEquals("Fail - lists must contain same amount of objects", algorithmList.size(), testedList.size());
    }
}
