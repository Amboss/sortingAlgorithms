package sortingAlgorithms;

import sortingAlgorithms.algorithms.SortingAlgorithm;
import sortingAlgorithms.algorithms.quadratic.BubbleSort;
import sortingAlgorithms.util.AppUtil;
import sortingAlgorithms.util.impl.AppUtilImpl;

import java.io.File;
import java.util.List;

/**
 * Main Class
 */
public class SortingAlgorithms {

    public static void main(String [] args) {

        AppUtil appUtil = new AppUtilImpl();

        String path = "testFile.txt";

        String newPath = "newFile.txt";

        File file = new File(path);

        SortingAlgorithm algorithms = new BubbleSort();

        if (file.exists()) {
            List<Integer> targetList = appUtil.loadArrayFromFile(path);

            if (targetList != null) {
                System.out.printf("%s", "Before:");
                appUtil.printValueToConsole(targetList);

                algorithms.sort(targetList);
                System.out.printf("\n%s", "After:");
                appUtil.printValueToConsole(targetList);
                appUtil.saveArrayToFile(newPath, targetList);

                System.out.printf("\n%s", "Reading " + newPath);
                appUtil.printValueToConsole(appUtil.loadArrayFromFile(newPath));
            }
        }
    }
}
