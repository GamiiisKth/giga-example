package se.joshua.test.asbtract;

import com.so4it.common.domain.AbstractIterable;

import java.util.Set;
import java.util.stream.Stream;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@konsult.folksam.se/>}
 */
public class Persons extends AbstractIterable<Person> {

    public Persons() {
        super(Person.class, Persons.class);
    }

    public static Persons valueOf(Person... people) {
        return valueOf(people, Person.class, Persons.class);
    }

    public static Persons valueOf(Set<Person> people) {
        return valueOf(people, Person.class, Persons.class);
    }


    private void run() {

    }

    public static void main(String[] args) {
        Person person = Person.builder()
                .withFirstName("ali0")
                .withLastName("joshua0")
                .withId("1")
                .build();
        Person person1 = Person.builder()
                .withFirstName("ali1")
                .withLastName("joshua1")
                .withId("2")
                .build();
        Person person2 = Person.builder()
                .withFirstName("ali2")
                .withLastName("joshua2")
                .withId("3")
                .build();
        Person person3 = Person.builder()
                .withFirstName("ali3")
                .withLastName("joshua3")
                .withId("4")
                .build();

        Persons people = Persons.valueOf(person, person1, person2, person3);



        people.asStream().filter(per -> Integer.valueOf(per.getId())>1 ).forEach(System.out::println);

    }
}
