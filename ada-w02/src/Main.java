import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student[] array = {new Student("John", 20), new Student("Jane", 25), new Student("Bob", 30)};
        long start = System.nanoTime();
        InsertSort<Student> sort = new InsertSort<>();
        StudentAgeComparator comparator = new StudentAgeComparator();
        sort.sort(array, comparator);
        System.out.println(Arrays.toString(array));


        long end = System.nanoTime();
        System.out.println("Time taken: " + (end - start) + " nanoseconds");
    }

}