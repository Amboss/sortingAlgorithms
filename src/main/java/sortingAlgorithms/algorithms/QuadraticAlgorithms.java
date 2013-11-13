package sortingAlgorithms.algorithms;

import java.util.List;

/**
 * Interface describe list of Quadratic algorithms;
 */
public interface QuadraticAlgorithms {

    /**
     * Selection sort - is a sorting algorithm, specifically an in-place comparison sort. The basic
     * idea is to look at each element in the array, and for each element look at all remaining elements
     * to see if there is something smaller that should be in this position. If there is, exchange the
     * two values. [http://www.leepoint.net/notes-java/data/arrays/31arrayselectionsort.html]
     *
     * @param list - contain array with unsorted integer values.
     * @throws RuntimeException
     * @return List<Integer>
     */
    public List<Integer> getSelectionSorting(List<Integer> list) throws RuntimeException;

    /**
     * Bubble sort - is a simple sorting algorithm that works by repeatedly stepping through the list
     * to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong
     * order. The pass through the list is repeated until no swaps are needed, which indicates that the
     * list is sorted. The algorithm gets its name from the way smaller elements "bubble" to the top of
     * the list. Because it only uses comparisons to operate on elements, it is a comparison sort.
     * Although the algorithm is simple, most of the other sorting algorithms are more efficient for
     * large lists. [http://en.wikipedia.org/wiki/Bubble_Sort]
     *
     * Disadvantages: not effective on a large amount of input array (more than 100).
     *
     * @param list - contain array with unsorted integer values.
     * @throws RuntimeException
     * @return ArrayList<Integer>
     */
    public List<Integer> getBubbleSorting(List<Integer> list) throws RuntimeException;

    /**
     * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one
     * item at a time. It is much less efficient on large lists than more advanced algorithms such as
     * quick sort, heap sort, or merge sort. However, insertion sort provides several advantages:
     * - Simple implementation,
     * - Efficient for (quite) small data sets,
     * - Adaptive (i.e., efficient) for data sets that are already substantially sorted: the time
     *      complexity is O(n + d), where d is the number of inversions,
     * - More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as
     *      selection sort or bubble sort; the best case (nearly sorted input) is O(n),
     * - Stable; i.e., does not change the relative order of elements with equal keys,
     * - In-place; i.e., only requires a constant amount O(1) of additional memory space,
     * - Online; i.e., can sort a list as it receives it. [http://en.wikipedia.org/wiki/Insert_sort]
     *
     * @param list - contain array with unsorted integer values.
     * @return ArrayList<Integer>
     */
    public List<Integer> getInsertSorting(List<Integer> list) throws RuntimeException;

    /**
     * Shell sort - is an in-place comparison sort. It generalizes an exchanging sort, such as insertion
     * or bubble sort, by starting the comparison and exchange of elements with elements that are far
     * apart before finishing with neighboring elements. Starting with far apart elements can move some
     * out-of-place elements into position faster than a simple nearest neighbor exchange.
     * [http://en.wikipedia.org/wiki/Shellsort]
     *
     * @param list - contain array with unsorted integer values.
     * @throws RuntimeException
     * @return ArrayList<Integer>
     */
    public List<Integer> getShellSorting(List<Integer> list) throws RuntimeException;
}
