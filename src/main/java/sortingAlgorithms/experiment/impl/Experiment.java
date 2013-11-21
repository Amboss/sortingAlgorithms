package sortingAlgorithms.experiment.impl;

import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.algorithms.linear.HeapSort;
import sortingAlgorithms.algorithms.linear.MergeSort;
import sortingAlgorithms.algorithms.linear.QuickSort;
import sortingAlgorithms.algorithms.linear.RadixSort;
import sortingAlgorithms.algorithms.quadratic.BubbleSort;
import sortingAlgorithms.algorithms.quadratic.InsertSort;
import sortingAlgorithms.algorithms.quadratic.SelectionSort;
import sortingAlgorithms.algorithms.quadratic.ShellSort;
import sortingAlgorithms.experiment.AppExperiment;
import sortingAlgorithms.util.AppTimer;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;
import sortingAlgorithms.util.impl.Timer;

import java.util.*;

/**
 * Class represents state and behavior of experiment object
 */
public class Experiment implements AppExperiment {

    private AppUtil appUtil = new AppUtilImpl();

    private AppTimer appTimer = new Timer();

    /*
     * settings[0] = amount;
     * settings[1] = maxRange;
     * settings[2] = iterations;
     */
    private int[] settings = new int[3];

    private Scanner scanner = null;

    private List<Integer> targetList = null;

    private Map<String, Long> resultMap = null;

    /**
     * @return Integer[]
     */
    @Override
    public int[] getSettingsForExperiment() {

        System.out.printf("\n\t%s", "Welcome to Sorting Algorithm experiment.");
        setPause(2);

        // determine the amount of list
        System.out.printf("\n%s", "Please enter the amount of numbers to be tested: ");
        scanner = new Scanner(System.in);
        settings[0] = scanner.nextInt();
        System.out.printf("\n%s: %d", "Amount", settings[0]);
        setPause(2);

        // determine the maxRange of list
        System.out.printf("\n%s", "Please enter the max range: ");
        settings[1] = scanner.nextInt();
        if (settings[1] >= settings[0]) {
            System.out.printf("\n%s: %d", "MaxRange", settings[1]);
            setPause(2);
        } else {
            System.out.printf("\n%s", "Max range must be bigger or equal to amount: ");
            getSettingsForExperiment();
        }

        // determine the amount of iterations
        System.out.printf("\n%s", "Please enter the amount of iterations: ");
        settings[2] = scanner.nextInt();
        System.out.printf("\n%s: %d", "iterations", settings[2]);
        setPause(2);



        if (scanner != null) {
            scanner.close();
        }
        return settings;
    }

    /**
     * Start experiment
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @param list     - list of SortingAlgorithm type objects
     * @return Map<String, Long>
     */
    @Override
    public Map<String, Long> startExperiment(int amount, int maxRange,
                                             int iterations, List<SortingAlgorithm> list) {

        System.out.printf("\n%s", "Starting experiment");

        // parameters check
        if (amount == 0 || maxRange == 0 || iterations == 0) {
            getSettingsForExperiment();
        }

        if (amount > maxRange) {
            System.out.printf("%s", "Max range must be bigger or equal to amount: ");
            setPause(3);
            getSettingsForExperiment();
        }

        // initiate all algorithms by default
        if (list == null) {
            list = initAllAlgorithms();
        }

        // generating list of unsorted random numbers
        targetList = appUtil.getRandomNumbers(amount, maxRange);

        // initiating
        resultMap = new HashMap<String, Long>();

        // iteration of list with algorithms objects
        System.out.printf("\n%s", "Measuring ...\n");
        for (SortingAlgorithm foo : list) {

            List<Long> timerResultList = new ArrayList<Long>();

            // iteration to get average time result
            for (int i = 1; i <= iterations; i++) {

                List<Integer> testList = new ArrayList<Integer>(targetList);
                appTimer.start();
                foo.sort(testList);
                appTimer.stop();

                // saving current result to list
                timerResultList.add(appTimer.getTotalTime());
            }

            // saving average time per algorithm type
            String currentClassName = foo.getClass().getName();
            resultMap.put(currentClassName, getAverageStatistical(timerResultList));
            System.out.printf("\n\t%s", "completed for: " + currentClassName);
        }
        System.out.printf("\n%s", "Experiment completed\n");
        return resultMap;
    }

    /**
     * Show result of experiment to console
     *
     * @param map - contains average results for each algorithm
     */
    @Override
    public void showResultsOfExperiment(Map<String, Long> map) {

        if (map == null) {
            System.out.printf("\n%s", "Some thing went wrong!!! ");
            setPause(3);
            getSettingsForExperiment();
        } else {

            System.out.printf("\n%s", "Displaying results:");
            setPause(2);
            Iterator it = map.entrySet().iterator();

            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry) it.next();
                System.out.printf("\n\t%s", pairs.getKey() + " : " + pairs.getValue() + " milliseconds");
                it.remove();
                setPause(1);
            }

        }
    }

    /**
     * Pause
     *
     * @param seconds - value in seconds
     */
    private void setPause(int seconds) {

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            System.out.printf("\n%s", "Some thing went wrong!!!");
        }
    }

    /**
     * Calculate Average Statistical index
     *
     * @param list - contain list of results from all iterations
     * @return Long
     */
    private Long getAverageStatistical(List<Long> list) {

        // parameters check
        if (list == null) {
            return null;
        }

        int iterations = list.size();
        Long sum = (long) 0;

        for (Long result : list) {
            sum += result;
        }
        return sum / iterations;
    }

    /**
     * Initiating SortingAlgorithm implementation and add them to algorithmList
     *
     * @return List<SortingAlgorithm>
     */
    private List<SortingAlgorithm> initAllAlgorithms() {

        System.out.printf("\n%s", "Initiating SortingAlgorithms");

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

        return algorithmList;
    }
}
