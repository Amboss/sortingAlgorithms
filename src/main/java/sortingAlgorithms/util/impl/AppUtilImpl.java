package sortingAlgorithms.util.impl;

import sortingAlgorithms.util.AppUtil;

import java.io.File;
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
     * Swapping elements in ArrayList
     *
     * @param list - array where replacement have to be made.
     * @param subject - target element to be replaced.
     * @param object - element to be replaced with.
     */
    public void swap(ArrayList<Integer> list, int subject, int object) {

        assert list != null;

        int temp = list.get(subject);

        list.set(subject, list.get(object));
        list.set(object, temp);
    }

    /**
     * Show array value in console
     *
     * @param list - array to shown in console
     */
    @Override
    public void getValueToConsole(ArrayList<Integer> list) {

        assert list != null;

        System.out.printf("\n%s", "Value of array: \n");

        for (Integer foo : list) {
            System.out.printf("%d, ", foo);
        }
    }

    /**
     * Read array from file
     *
     * @param file - target file with array
     * @return ArrayList with amount of numbers
     */
    @Override
    public ArrayList<Integer> loadArrayFromFile(File file) {

        assert file != null;

        return null;
    }

    /**
     * Write array to file
     *
     * @param file - target file where array must be saved
     * @param list - array that have to be saved
     */
    @Override
    public void saveArrayToFile(File file, ArrayList<Integer> list) {

        assert list != null;
        assert file != null;


    }
}
