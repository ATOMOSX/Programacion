package co.edu.uniquindio.ingesis;

import java.util.function.Predicate;

public class PersonFilterUtil implements Predicate<Person>{

    private final int age;

    public PersonFilterUtil(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Person person) {
        return person.getAge() < age;
    }
}
