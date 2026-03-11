import java.util.Comparator;

public class InsertSort <T extends Comparable<T>> {
    public void sort(T a[], Comparator<T> comparator) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (comparator.compare(a[j], a[j-1]) < 0) {
                    T temp = a[j];
                    a[j] = a[j-1];
                    a[j-1] = temp;
                }
            }
        }

    }
}
