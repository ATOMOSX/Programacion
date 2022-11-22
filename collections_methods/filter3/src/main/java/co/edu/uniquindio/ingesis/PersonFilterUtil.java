package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonFilterUtil implements Predicate<Person>{
    @Override
    public boolean test(Person person) {
        return person.getAge() < 20;
    }
}
