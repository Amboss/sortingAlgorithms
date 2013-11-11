package sortingAlgorithms;

import sortingAlgorithms.algoritms.LinearAlgorithms;
import sortingAlgorithms.algoritms.linear.LinearAlgorithmsImpl;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.List;

/**
 * Main Class
 */
public class SortingAlgorithms {

    public static void main(String [] args) {

        AppUtil appUtil = new AppUtilImpl();

        //QuadraticAlgorithms quadraticAlgorithms = new QuadraticAlgorithmsImpl();

        LinearAlgorithms linearAlgorithms = new LinearAlgorithmsImpl();

        List<Integer> list = appUtil.getRandomNumbers(20, 20);

        appUtil.getValueToConsole(list);

        //appUtil.getValueToConsole(quadraticAlgorithms.getBubbleSorting(list));

        appUtil.getValueToConsole(linearAlgorithms.getRadixSorting(list));
    }
}
