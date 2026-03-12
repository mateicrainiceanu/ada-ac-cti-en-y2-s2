package comparators;

import data.Person;

import java.util.Comparator;

public class PeopleComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.lastName().compareTo(o2.lastName());
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
