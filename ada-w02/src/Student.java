public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        if (this.name.equals(o.getName()))
            return this.age - o.age;
        return this.getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return this.name + " " + this.age;
    }
}
