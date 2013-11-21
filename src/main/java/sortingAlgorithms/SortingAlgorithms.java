package sortingAlgorithms;

import sortingAlgorithms.unitTest.algorithms.SortingAlgorithm;
import sortingAlgorithms.unitTest.algorithms.quadratic.BubbleSort;
import sortingAlgorithms.unitTest.util.AppUtil;
import sortingAlgorithms.unitTest.util.impl.AppUtilImpl;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Main Class
 */
public class SortingAlgorithms {

    public static void main(String [] args) {

        AppUtil appUtil = new AppUtilImpl();

        String path = "testFile.txt";

        String newPath = "newFile.txt";

        int amount = 10,  maxRange = 10;

        File file = new File(path);

        List<Integer> targetList = appUtil.getRandomNumbers(amount, maxRange);

        //appUtil.saveArrayToFile(path, randomList);

        SortingAlgorithm algorithms = new BubbleSort();

        //if (file.exists()) {
            //List<Integer> targetList = appUtil.loadArrayFromFile(path);

            if (targetList != null) {
                System.out.printf("%s", "Before:");
                appUtil.printValueToConsole(targetList);

                long startTime = new Date().getTime();

                algorithms.sort(targetList);

                long endTime   = new Date().getTime();
                long totalTime = endTime - startTime;
                System.out.println("time: " + totalTime);

                System.out.printf("\n%s", "After:");
                appUtil.printValueToConsole(targetList);
                appUtil.saveArrayToFile(newPath, targetList);

                System.out.printf("\n%s", "Reading " + newPath);
                appUtil.printValueToConsole(appUtil.loadArrayFromFile(newPath));
            }
        //}
    }
}
