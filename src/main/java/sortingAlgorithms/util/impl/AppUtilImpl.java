package sortingAlgorithms.util.impl;

import sortingAlgorithms.util.AppUtil;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Implementation of methods for additional functionality.
 */
public class AppUtilImpl implements AppUtil {

    /**
     * Get defined amount of random numbers from defined range
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @return ArrayList with amount of numbers
     */
    @Override
    public ArrayList<Integer> getRandomNumbers(Integer amount, Integer maxRange) {

        assert amount != null : "Amount not specified!";
        assert amount >= 1 : "Amount can't be less then 1!";
        assert maxRange != null : "MaxRange not specified!";
        assert maxRange >= 1 : "MaxRange can't be less then 1!";

        // define ArrayList to hold Integer objects
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i <= maxRange - 1; i++) {
            arrayList.add(i);
        }

        // shuffle list
        Collections.shuffle(arrayList);

        // adding defined amount of numbers to target list
        ArrayList<Integer> targetList = new ArrayList<>();
        for (int j = 0; j < amount; j++) {
            targetList.add(arrayList.get(j));
        }
        return targetList;
    }

    /**
     * Show array value in console
     */
    @Override
    public void getValueToConsole(ArrayList<Integer> list) {

        System.out.printf("\n%s", "Value of array: \n");

        for (Integer foo : list) {
            System.out.printf("%d, ", foo);
        }
    }
}
