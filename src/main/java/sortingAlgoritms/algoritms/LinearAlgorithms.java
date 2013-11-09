package sortingAlgoritms.algoritms;

import java.util.ArrayList;

/**
 * Interface describe list of Linear algorithms
 */
public interface LinearAlgorithms {

    /**
     * Heap sort is a comparison-based sorting algorithm to create a sorted array (or list), and is part
     * of the selection sort family. Although somewhat slower in practice on most machines than a
     * well-implemented quicksort, it has the advantage of a more favorable worst-case O(n log n)
     * runtime. Heapsort is an in-place algorithm, but it is not a stable sort.
     * [http://en.wikipedia.org/wiki/HeapSort]
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getHeapSorting(ArrayList<Integer> list);

    /**
     * Quick sort, or partition-exchange sort, is a sorting algorithm developed by Tony Hoare that, on
     * average, makes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2)
     * comparisons, though this behavior is rare. Quicksort is often faster in practice than other
     * O(n log n) algorithms.[1] Additionally, quicksort's sequential and localized memory references
     * work well with a cache. Quicksort is a comparison sort and, in efficient implementations, is not
     * a stable sort. [http://en.wikipedia.org/wiki/QuickSort]
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getQuickSorting(ArrayList<Integer> list);

    /**
     * Radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by
     * grouping keys by the individual digits which share the same significant position and value. A
     * positional notation is required, but because integers can represent strings of characters (e.g.,
     * names or dates) and specially formatted floating point numbers, radix sort is not limited to
     * integers. [http://en.wikipedia.org/wiki/Radix_sort]
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getRadixSorting(ArrayList<Integer> list);

    /**
     * MergeSort -  is an O(n log n) comparison-based sorting algorithm. Most implementations produce
     * a stable sort, which means that the implementation preserves the input order of equal elements
     * in the sorted output. [http://en.wikipedia.org/wiki/MergeSort]
     *
     * @param list - contain array with unsorted integer values;
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getMergeSorting(ArrayList<Integer> list);
}
