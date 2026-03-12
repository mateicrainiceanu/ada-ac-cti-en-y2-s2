package data;

import java.time.LocalDate;

public record Person(String id, String firstName, String lastName, LocalDate birthDate) {
    @Override
    public String toString() {
        return "Person {" + id + " " + firstName + " " + lastName + " " + birthDate + "}\n";
    }
}