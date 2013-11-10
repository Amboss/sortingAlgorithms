package sortingAlgorithms.util;

import java.io.File;
import java.util.ArrayList;

/**
 * Interface describes methods for additional functionality.
 */
public interface AppUtil {

    /**
     * get defined amount of random numbers from defined range
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @return ArrayList with amount of numbers
     */
    public ArrayList<Integer> getRandomNumbers(Integer amount, Integer maxRange);

    /**
     * Swap method for ArrayList
     *
     * @param list - array where replacement have to be made.
     * @param subject - target element to be replaced.
     * @param object - element to be replaced with.
     */
    public void swap(ArrayList<Integer> list, int subject, int object);

    /**
     * Show array value in console
     *
     * @param list - array to shown in console
     */
    public void getValueToConsole(ArrayList<Integer> list);

    /**
     * Read array from file
     *
     * @param file - target file with array
     * @return ArrayList with amount of numbers
     */
    public ArrayList<Integer> loadArrayFromFile(File file);

    /**
     * Write array to file
     *
     * @param file - target file where array must be saved
     * @param list - array that have to be saved
     */
    public void saveArrayToFile(File file, ArrayList<Integer> list);
}
