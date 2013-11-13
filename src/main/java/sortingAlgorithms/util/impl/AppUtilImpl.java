package sortingAlgorithms.util.impl;

import sortingAlgorithms.util.AppUtil;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
     * @throws IllegalArgumentException
     */
    @Override
    public List<Integer> getRandomNumbers(int amount, int maxRange) throws IllegalArgumentException {

        if (amount < 1 || maxRange < 1) {
            throw new IllegalArgumentException("Amount or maxRange can't be less then 1!");
        }

        // define ArrayList to hold Integer objects
        List<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i <= maxRange - 1; i++) {
            arrayList.add(i);
        }

        // shuffle list
        Collections.shuffle(arrayList);

        // adding defined amount of numbers to target list
        List<Integer> targetList = new ArrayList<>();
        for (int j = 0; j < amount; j++) {
            targetList.add(arrayList.get(j));
        }
        return targetList;
    }

    /**
     * Swapping elements in ArrayList
     *
     * @param list    - array where replacement have to be made.
     * @param subject - target element to be replaced.
     * @param object  - element to be replaced with.
     * @throws RuntimeException
     */
    public void swap(List<Integer> list, int subject, int object) throws IllegalArgumentException {

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("swap error: disallowed value");
        }

        int temp = list.get(subject);

        list.set(subject, list.get(object));
        list.set(object, temp);
    }

    /**
     * Show array value in console
     *
     * @param list - array to shown in console
     * @throws IllegalArgumentException
     */
    @Override
    public void getValueToConsole(List<Integer> list) throws IllegalArgumentException {

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
    public List<Integer> loadArrayFromFile(String url) throws RuntimeException {

        if (url == null) {
            throw new IllegalArgumentException("ERROR: url is not specified!");
        }

       List<Integer> targetList = new ArrayList<>();

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
    public void saveArrayToFile(String fileName, List<Integer> list) throws IllegalArgumentException {

        // checking input parameter for null
        if (fileName == null || list == null) {
            throw new IllegalArgumentException("ERROR: url is not specified!");
        }

        // supporting path and encoding parameters
        Charset ENCODING = StandardCharsets.UTF_8;

        Path path = Paths.get(fileName);

        // converting to String list
        List<String> targetList = new ArrayList<>();

        for (Integer foo : list) {
            targetList.add(String.valueOf(foo));
        }

        // creating new file with target list
        try {
            Files.write(path, targetList, ENCODING);
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while writing " + fileName + " file!");
        }
    }

    /**
     * Validate content of file
     *
     * @param list - target array to be validated
     * @return boolean
     * @throws IllegalArgumentException
     */
    @Override
    public boolean validateArrayContent(List<String> list) throws IllegalArgumentException {

        // checking input parameter for null
        if (list == null) {
            throw new IllegalArgumentException("array not specified!");
        }

        boolean foo = true;

        for (String targetValue : list) {
            Pattern textPattern = Pattern.compile("\\d+(,\\d+)*(\\.\\d+)?");
            Matcher valueMatcher = textPattern.matcher(targetValue);
            if (!valueMatcher.matches()) {
                return false;
            }
        }

        return foo;
    }
}
