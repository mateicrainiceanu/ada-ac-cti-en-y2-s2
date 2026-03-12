package sorters;

import java.util.Comparator;

public class InsertionSorter<T> implements Sorter2<T>{
    @Override
    public String getName() {
        return "Insert Sorter";
    }

    @Override
    public void sort(T[] a, Comparator<T> comparator) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; (j > 1) && (comparator.compare(a[j], a[j - 1]) < 0); j--) {
                // System.out.println(a.length + " " + i + " " + j);
                T temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
            }
        }
    }
}
