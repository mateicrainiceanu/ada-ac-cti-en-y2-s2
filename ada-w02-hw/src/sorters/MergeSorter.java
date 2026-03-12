package sorters;

import java.util.Comparator;

public class MergeSorter<T> implements Sorter2<T> {

    private T[] a;
    private T[] aux;
    private Comparator<T> comparator;

    @Override
    public String getName() {
        return "MergeSorter";
    }

    @Override
    public void sort(T[] a, Comparator<T> comparator) {
        this.a = a;
        this.aux = (T[]) new Object[a.length];
        this.comparator = comparator;
        mergeSort(0, a.length - 1);
    }

    private void mergeSort(int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;

        mergeSort(lo, mid);
        mergeSort(mid + 1, hi);

        if (comparator.compare(a[mid + 1], a[mid]) >= 0) return;

        merge(lo, mid, hi);
    }

    private void merge(int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                                  a[k] = aux[j++];
            else if (j > hi)                                   a[k] = aux[i++];
            else if (comparator.compare(aux[j], aux[i]) < 0)  a[k] = aux[j++];
            else                                               a[k] = aux[i++];
        }
    }
}
