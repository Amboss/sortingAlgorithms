package sortingAlgorithms.util;

import java.util.ArrayList;

/**
 * Interface describes methods for additional functionality.
 */
public interface AppUtil {

    /**
     * get defined amount of random numbers from defined range
     *
     * @param amount - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @return ArrayList with amount od numbers
     */
    public ArrayList<Integer> getRandomNumbers(Integer amount, Integer maxRange);

    /**
     * Show array value in console
     */
    public void getValueToConsole(ArrayList<Integer> list);
}
