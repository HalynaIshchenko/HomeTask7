package HomeTask7.Task1;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

/*Створити клас Person з полями вік, ім’я, timestamp. Зробити конструктор і включити в нього 2 поля
 вік та ім’я.
Написати лямбда-функцію , яка для кожного елемента(елементом є користувач) ліста перевіряє вік,
і повнолітніх заносить в інший ліст.
Написати лямбда-функцію, яка для кожного елемента ліста(List<Person>) встановлює (setDate) поле поточна дата.
Написати лямбда-функцію яка перебирає кожен елемент списку (List<String>)
і записує в інший ліст довжини слів з першого списку.


 */
public class Main {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        personList.add(new Person(15, "a"));
        personList.add(new Person(32, "b"));
        personList.add(new Person(12, "c"));
        personList.add(new Person(52, "d"));

        // case 1
        List<Person> personFilteredList = new ArrayList<>();
        personList.forEach(person -> {
            if (person.getAge() >= 18) {
                personFilteredList.add(person);
            }
        });
        personFilteredList.forEach(person -> out.println(person));

        // case 2
        personList.forEach(person -> {
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            person.setTimestamp(timestamp);
        });

        personList.forEach(person -> out.println(person));

        //case 3
        List<String> listWithWords = Arrays.asList("son", "mother", "father", "brother", "sister");
        List<Integer> listWithLengthWords = new ArrayList<>();
        listWithWords.forEach(w ->
                listWithLengthWords.add(w.length()));
        listWithLengthWords.forEach(System.out::println);
    }

}
