import comparators.PeopleComparator;
import data.Person;
import io.PersonFileReader;
import sorters.ArraySorter;
import sorters.InsertionSorter;
import sorters.MergeSorter;
import sorters.Sorter2;
import utilities.SortingUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();

        try {
            File file = new File("ada-w02-hw/" + fileName);
            Scanner fileScanner = new Scanner(file);
            PersonFileReader reader = new PersonFileReader(fileScanner);
            ArrayList<Person> people = reader.getPeople();

            Comparator<Person> comparator = new PeopleComparator();

            Person[] people1 = people.toArray(new Person[0]);
            Sorter2<Person> sorter = new MergeSorter<Person>();
            SortingUtil.sortArrayAndPrintStat(people1, sorter, comparator);

            Person[] people3 = people.toArray(new Person[0]);
            Sorter2<Person> sorter3 = new ArraySorter<>();
            SortingUtil.sortArrayAndPrintStat(people3, sorter3, comparator);

            Person[] people2 = people.toArray(new Person[0]);
            Sorter2<Person> sorter2 = new InsertionSorter<>();
            SortingUtil.sortArrayAndPrintStat(people2, sorter2, comparator);

            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        scanner.close();
    }
}