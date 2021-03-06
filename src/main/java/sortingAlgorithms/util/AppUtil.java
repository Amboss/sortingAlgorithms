package sortingAlgorithms.util;

import java.util.List;

/**
 * Interface describes methods for additional functionality.
 */
public interface AppUtil {

    /**
     * get defined amount of random numbers from defined range
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @return List with amount of numbers
     */
    public List<Integer> getRandomNumbers(int amount, int maxRange);

    /**
     * Swap method for ArrayList
     *
     * @param list    - array where replacement have to be made.
     * @param subject - target element to be replaced.
     * @param object  - element to be replaced with.
     */
    public void swap(List<Integer> list, int subject, int object);

    /**
     * Show array value in console
     *
     * @param list - array to shown in console
     */
    public void printValueToConsole(List<Integer> list);

    /**
     * Read array from file
     *
     * @param path - target file with array
     * @return List with amount of numbers
     */
    public List<Integer> loadArrayFromFile(String path);

    /**
     * Write array to file
     *
     * @param file - target file where array must be saved
     * @param list - array that have to be saved
     */
    public void saveArrayToFile(String file, List<Integer> list);
}
