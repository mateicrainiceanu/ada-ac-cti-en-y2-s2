package comparators;

import data.Person;

import java.util.Comparator;

public class PrioritisedCompare implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.prioritized() && !o2.prioritized()) return -1;
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}

