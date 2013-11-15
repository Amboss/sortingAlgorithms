package sortingAlgorithms.util.impl;

import sortingAlgorithms.util.AppUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

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
    public List<Integer> getRandomNumbers(int amount, int maxRange) {

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
     * @param list  - array where replacement have to be made.
     * @param right - index of element to be replaced with.
     * @param left  - index of element to be replaced.
     * @throws IllegalArgumentException
     */
    @Override
    public void swap(List<Integer> list, int left, int right) {

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
    public void printValueToConsole(List<Integer> list) {

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
     * @param path - target file with array
     * @return List with amount of numbers
     * @throws RuntimeException, IOException
     */
    @Override
    public List<Integer> loadArrayFromFile(String path) {

        if (path == null) {
            throw new IllegalArgumentException("Path is not specified!");
        }

        List<Integer> list = new ArrayList<Integer>();

        String line;

        BufferedReader bufferedReader = null;

        try {
            FileInputStream fileInputStream = new FileInputStream(path);

            // reading the primitive data from the input stream
            DataInputStream dataInputStream = new DataInputStream(fileInputStream);

            // read data efficiently as characters
            bufferedReader = new BufferedReader(new InputStreamReader(dataInputStream));

            // processing the lines in file
            while ((line = bufferedReader.readLine()) != null) {
                processLine(line, list);
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found!");
        } finally {

            // closing bufferedReader
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException ignored) {
            }
        }
        return list;
    }

    /*
     * Parsing string to integer and add to list
     * @param line - the line of the file to read the integers from
     * @return List<Integer>
     */
    private List<Integer> processLine(String line, List<Integer> list) {

        Scanner scanner = new Scanner(line); //create scanner for line

        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        return list;
    }

    /**
     * Write array to file
     *
     * @param path - name of target file where array must be saved
     * @param list - array that have to be saved
     * @throws IllegalArgumentException
     */
    @Override
    public void saveArrayToFile(String path, List<Integer> list) {

        // checking input parameter for null
        if (path == null || list == null) {
            throw new IllegalArgumentException("ERROR: url is not specified!");
        }

        try {
            File file = new File(path);
            PrintWriter printWriter = new PrintWriter(file);
            if (file.exists()) {
                for (int foo: list) {
                    printWriter.print(String.valueOf(foo));
                    printWriter.print(" ");
                }
            }

            printWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error while saving to file: " + path);
        }
    }
}
