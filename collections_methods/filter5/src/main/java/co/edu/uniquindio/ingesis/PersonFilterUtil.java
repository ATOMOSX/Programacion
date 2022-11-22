package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonFilterUtil {
    public static Predicate<Person> filterByAgeLessThan(final int age){
        Predicate<Person> predicate = new Predicate<>() {
            @Override
            public boolean test(Person person) {
                return person.getAge() < age;
            }
        };
        return predicate;
    }
}
