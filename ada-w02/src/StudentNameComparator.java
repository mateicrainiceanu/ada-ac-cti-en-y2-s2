import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
            if (s1.getName().equals(s2.getName()))
                return s1.getAge() - s2.getAge();
            return s1.getName().compareTo(s2.getName());
    }
}
