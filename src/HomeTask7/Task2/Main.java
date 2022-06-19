package HomeTask7.Task2;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {


        List<Person> personList = Arrays.asList(
                new Person("A"),
                new Person(22, "B"),
                new Person("C"),
                new Person(2, "D"));


        personList.forEach(person -> {
                    // possible case Optional.of() usage (name must be always present)
                    Optional<String> name = Optional.of(person.getName());
                    System.out.println(name.map(String::toLowerCase).get());

                    // possible case Optional.ofNullable() usage
                    // possible case Optional.orElseGet() usage
                    Optional<String> secondName = Optional.ofNullable(person.getSecondName());
                    System.out.println(
                            secondName.orElseGet(() -> String.format("Info: %s has empty second name", person.getName())));

                    // possible case of isEmpty() usage
                    Optional<Integer> age = Optional.ofNullable(person.getAge());
                    age.ifPresent(System.out::println);
                    if (age.isEmpty()) {
                        person.setAge(44);
                        System.out.println(person.getAge());
                    }

                    //  possible case of orElse usage
                    person.setTimestamp(Optional.ofNullable(person.getTimestamp())
                            .orElse(new Timestamp(new Date().getTime())));
                    System.out.println(person.getTimestamp());

                }
        );


        // possible case of ifPresent() usage
        Optional<Person> found = personList.stream().filter(person -> person.getAge().equals(44)).findFirst();
        // when we won't stop application
        if (found.isPresent()) {
            System.out.println("Info: Person with age 44 was found");
        }

        // possible case of orElseThrow() usage
        int age = 33;
        //when we want stop application if search didn't find value
        Optional.ofNullable(personList.stream().filter(person -> person.getAge().equals(age)).findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Person with age %s was Not found",age))));



    }


}
