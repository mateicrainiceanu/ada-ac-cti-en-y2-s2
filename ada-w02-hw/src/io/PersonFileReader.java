package io;

import data.Person;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonFileReader {
    private final ArrayList<Person> people = new ArrayList<Person>();

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public PersonFileReader(Scanner sc) {
        parseFile(sc);
    }

    private void parseFile(Scanner scanner) {
        String _first = scanner.nextLine();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            processLine(line);
        }
    }

    private void processLine(String line) {
        String[] parts = line.split(" ");

        String id        = parts[0];
        String firstName = parts[1];
        String lastName  = parts[2];
        LocalDate date   = LocalDate.parse(parts[3], DATE_FORMAT);

        Person person = new Person(id, firstName, lastName, date);
        people.add(person);
    }

    public ArrayList<Person> getPeople() {
        return people;
    }
}
