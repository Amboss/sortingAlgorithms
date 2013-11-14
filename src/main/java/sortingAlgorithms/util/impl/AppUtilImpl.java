package sortingAlgorithms.util.impl;

import sortingAlgorithms.util.AppUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of methods for additional functionality.
 */
public class AppUtilImpl implements AppUtil {

    private final String REGEX = "\\d+(,\\d+)*(\\.\\d+)?";

    private Pattern textPattern = Pattern.compile(REGEX);

    /**
     * Get defined amount of random numbers from defined range
     *
     * @param amount   - defined amount of random numbers
     * @param maxRange - maximum range of numbers
     * @return ArrayList with amount of numbers
     * @throws IllegalArgumentException
     *
     */
    @Override
    public List<Integer> getRandomNumbers(int amount, int maxRange)  {

        if (amount < 1 || maxRange < 1) {
            throw new IllegalArgumentException("Amount or maxRange can't be less then 1!");
        }

        Random random = new Random();

        List<Integer> targetList = new ArrayList<>();

        for (int j = 0; j < amount; j++) {
            targetList.add(random.nextInt(maxRange));
        }
        return targetList;
    }

    /**
     * Swapping elements in ArrayList
     *
     * @param list    - array where replacement have to be made.
     * @param right  - index of element to be replaced with.
     * @param left - index of element to be replaced.
     * @throws RuntimeException
     */
    public void swap(List<Integer> list, int left, int right){

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("swap error: disallowed value");
        }

        int temp = list.get(left);
        list.set(left, list.get(right));
        list.set(right, temp);
    }

    /**
     * Show array value in console
     *
     * @param list - array to shown in console
     * @throws IllegalArgumentException
     */
    @Override
    public void printValueToConsole(List<Integer> list){

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("array not specified!");
        }

        System.out.printf("\n%s", "Value of array: \n");

        for (Integer foo : list) {
            System.out.printf("%d, ", foo);
        }
    }

    /**
     * Read array from file
     *
     * @param url - target file with array
     * @return List with amount of numbers
     * @throws RuntimeException
     */
    @Override
    public List<Integer> loadArrayFromFile(String url){

        if (url == null) {
            throw new IllegalArgumentException("ERROR: url is not specified!");
        }

       List<Integer> targetList = new ArrayList<Integer>();

//        BufferedReader reader = null;
//        File file = new File(url);
//        String text;
//
//        try {
//            // reading content of file
//            reader = new BufferedReader(new FileReader(file));
//
//            //
//            while (reader.readLine().matches()) {
//                targetList.add(Integer.parseInt(text));
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("Error occurred wile reading target file!");
//        } finally {
//            try {
//                if (reader != null) {
//                    reader.close();
//                }
//            } catch (IOException ignored) {
//            }
//        }
        return targetList;
    }

    /**
     * Write array to file
     *
     * @param fileName - name of target file where array must be saved
     * @param list     - array that have to be saved
     * @throws IllegalArgumentException
     */
    @Override
    public void saveArrayToFile(String fileName, List<Integer> list){

        // checking input parameter for null
        if (fileName == null || list == null) {
            throw new IllegalArgumentException("ERROR: url is not specified!");
        }

//        // supporting path and encoding parameters
//        Charset ENCODING = StandardCharsets.UTF_8;
//
//        Path path = Paths.get(fileName);
//
//        // converting to String list
//        List<String> targetList = new ArrayList<Integer>();
//
//        for (Integer foo : list) {
//            targetList.add(String.valueOf(foo));
//        }
//
//        // creating new file with target list
//        try {
//            Files.write(path, targetList, ENCODING);
//        } catch (IOException e) {
//            throw new RuntimeException("Error occurred while writing " + fileName + " file!");
//        }
    }

    /**
     * Validate content of file
     *
     * @param list - target array to be validated
     * @return boolean
     * @throws IllegalArgumentException
     */
    @Override
    public boolean validateArrayContent(List<String> list){

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("array not specified!");
        }

        boolean foo = true;

        for (String targetValue : list) {
            Matcher valueMatcher = textPattern.matcher(targetValue);
            if (!valueMatcher.matches()) {
                return false;
            }
        }
        return foo;
    }
}
