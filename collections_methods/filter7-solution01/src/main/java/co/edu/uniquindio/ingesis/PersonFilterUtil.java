package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonFilterUtil {
    public static Predicate<Person> filterByAgeLessThan(final int age){
        return (person)->person.getAge()<age;
    }

    public static Predicate<Person> filterByNameEqualTo(final String name){
        return (person)->person.getName().equals(name);
    }

    public static Predicate<Person> filterBySexEqualTo(final Sex sex){
        return (person)->person.getSex() == sex;
    }
}
