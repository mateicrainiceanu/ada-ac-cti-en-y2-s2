package utilities;

import sorters.Sorter2;

import java.util.Comparator;

public class SortingUtil {
    public static <T> void sortArrayAndPrintStat(T[] a, Sorter2<T> sorter, Comparator<T> comparator) {
        long start = System.nanoTime();
        sorter.sort(a, comparator);
        long end = System.nanoTime();
        System.out.println(sorter.getName() + " took " + (end - start) / 1000000 + " milliseconds");
    }
}
