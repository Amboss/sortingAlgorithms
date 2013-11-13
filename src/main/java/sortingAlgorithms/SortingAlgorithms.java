package sortingAlgorithms;

import sortingAlgorithms.algorithms.LinearAlgorithms;
import sortingAlgorithms.algorithms.impl.LinearAlgorithmsImpl;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class
 */
public class SortingAlgorithms {

    public static void main(String [] args) {

        AppUtil appUtil = new AppUtilImpl();

        //QuadraticAlgorithms quadraticAlgorithms = new QuadraticAlgorithmsImpl();

        LinearAlgorithms linearAlgorithms = new LinearAlgorithmsImpl();

        List<Integer> targetList = new ArrayList<>();

        try {
            targetList = appUtil.loadArrayFromFile("D:\\JAVAprojects\\desckTopApp\\sortingAlgorithms\\testFile.txt");

            System.out.println("\nBefore:");
            appUtil.getValueToConsole(targetList);

            System.out.println("After:");
            appUtil.getValueToConsole(linearAlgorithms.getMergeSorting(targetList));
        } catch (IllegalArgumentException e) {
            System.out.println("ops =)" + e);
        }
    }
}
