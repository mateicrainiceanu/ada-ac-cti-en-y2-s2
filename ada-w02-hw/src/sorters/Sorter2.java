package sorters;

import java.util.Comparator;

public interface Sorter2<T> {
    String getName();
    void sort(T[] a, Comparator<T> comparator);
}