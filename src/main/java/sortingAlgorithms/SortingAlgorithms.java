package sortingAlgorithms;

import sortingAlgorithms.algorithms.LinearAlgorithms;
import sortingAlgorithms.algorithms.impl.LinearAlgorithmsImpl;
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

        List<Integer> targetList = appUtil.loadArrayFromFile("D:\\JAVAprojects\\desckTopApp\\sortingAlgorithms\\testFile.txt");

        System.out.println("Before:");
        appUtil.printValueToConsole(targetList);

        System.out.println("After:");
        appUtil.printValueToConsole(linearAlgorithms.getMergeSorting(targetList));
    }
}
