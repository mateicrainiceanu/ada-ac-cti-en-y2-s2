package sorters;

import java.util.Arrays;
import java.util.Comparator;

public class ArraySorter<T> implements Sorter2<T>{

    @Override
    public String getName() {
        return "Array Sorter";
    }

    @Override
    public void sort(T[] a, Comparator<T> comparator) {
        Arrays.sort(a, comparator);
    }
}
