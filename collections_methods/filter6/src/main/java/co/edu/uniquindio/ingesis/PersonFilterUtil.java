package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonFilterUtil {
    public static Predicate<Person> filterByAgeLessThan(final int age){
        return (person)->person.getAge()<age;
    }
}
