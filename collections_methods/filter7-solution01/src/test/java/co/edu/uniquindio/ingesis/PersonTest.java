package co.edu.uniquindio.ingesis;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static co.edu.uniquindio.ingesis.Sex.FEMALE;
import static co.edu.uniquindio.ingesis.Sex.MALE;

class PersonTest {

    @Test
    void filter() {
        List<Person> list = new ArrayList<>();

        list.add(new Person("Miguel", 18,MALE));
        list.add(new Person("Juan", 20,MALE));
        list.add(new Person("Ana", 18,FEMALE));
        list.add(new Person("Camilo", 19,MALE));
        list.add(new Person("Miguel", 23,MALE));
        list.add(new Person("Camilo", 17,MALE));

        for (Person person : list) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        System.out.println("filtering...");

        List<Person> listResult = list.stream()
                .filter(PersonFilterUtil.filterBySexEqualTo(MALE).and(PersonFilterUtil.filterByAgeLessThan(20).negate()))
                .collect(Collectors.toList());

                // this line is equivalent to the for in the line 21
        listResult.forEach(person -> System.out.println(person.getName() + " " + person.getAge()));

    }
}