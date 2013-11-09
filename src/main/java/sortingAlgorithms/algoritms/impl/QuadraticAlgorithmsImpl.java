package sortingAlgorithms.algoritms.impl;

import sortingAlgorithms.algoritms.QuadraticAlgorithms;

import java.util.ArrayList;

/**
 * Implementation of Quadratic algorithms.
 */
public class QuadraticAlgorithmsImpl implements QuadraticAlgorithms {

    /**
     * Selection sort
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getSelectionSorting(ArrayList<Integer> list) {

        assert list != null : "arrayList not specified!";

        // moving forward through array
        for (int i = 0; i < list.size() - 1; i++) {

            // look at all remaining elements to see if there is something smaller
            for (int j = i + 1; j < list.size(); j++) {

                if (list.get(i) > list.get(j)) {
                    // exchange the two values if there is
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    }

    /**
     * Bubble sort
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getBubbleSorting(ArrayList<Integer> list) {

        assert list != null : "arrayList not specified!";

        // moving forward through array.
        for (int i = list.size() - 1; i >= 2; i--) {

            boolean sorted = true;

            // set the correct order between near elements.
            for (int j = 0; j < i; j++) {

                // swap places if the order of  elements are not correct and mark swap.
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                    sorted = false;
                }
            }
            // stop if no changes was made.
            if (sorted) {
                break;
            }
        }
        return list;
    }

    /**
     * Insertion sort
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getInsertSorting(ArrayList<Integer> list) {

        assert list != null : "arrayList not specified!";

        int i, j, temp;

        // moving forward through array.
        for (i = 1; i < list.size(); i++) {
            j = i;

            // moving element back, while element bigger than others.
            while (j > 0 && list.get(j - 1) > list.get(j)) {
                temp = list.get(j);
                list.set(j, list.get(j - 1));
                list.set(j - 1, temp);
                j--;
            }
        }
        return list;
    }

    /**
     * Shell sort
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    @Override
    public ArrayList<Integer> getShellSorting(ArrayList<Integer> list) {

        assert list != null : "arrayList not specified!";

        int i, j, increment, temp, arraySize = list.size();

        // moving forward through array.
        for (increment = arraySize / 2; increment > 0; increment /= 2) {

            for (i = increment; i < arraySize; i++) {
                temp = list.get(i);
                for (j = i; j >= increment; j -= increment) {
                    // comparing distant elements
                    if (temp < list.get(j - increment)) {
                        list.set(j, list.get(j - increment));
                    } else {
                        break;
                    }
                }
                list.set(j, temp);
            }
        }
        return list;
    }
}