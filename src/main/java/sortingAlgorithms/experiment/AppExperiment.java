package sortingAlgorithms.experiment;

import sortingAlgorithms.algorithms.SortingAlgorithm;

import java.util.List;
import java.util.Map;

/**
 * Interface defines method of experiment
 */
public interface AppExperiment {

    /**
     * @return Integer[]
     */
    public int[] getSettingsForExperiment();

    /**
     * Start experiment
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @param list     - list of SortingAlgorithm type objects
     * @return Map<String, Long>
     */
    public Map<String, Long> startExperiment(int amount, int maxRange,
                                             int iterations, List<SortingAlgorithm> list);

    /**
     * Show result of experiment to console
     *
     * @param map - contains average results for each algorithm
     */
    public void showResultsOfExperiment(Map<String, Long> map);
}
