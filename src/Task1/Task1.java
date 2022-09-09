package HomeWork2.Task1;

/*
Задание 1.
Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени
*/

/*
Что должно получиться
        Key: Amelia
        Value:4
        Key: Emily
        Value:1
        Key: Harry
        Value:3
        Key: Jack
        Value:1
*/


import java.util.*;
import java.util.stream.Collectors;

public class Task1 {
    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    /*Отсюда начинается мое решение. Для удобства проверяющих все было сделано в рамках класса Task1.*/

    //Простой exception для задания
    static class NullArgumentException extends Exception {
    }

    //Метод, который делает необходимые преобразования и выводит на экран результат
    static void preprocessing(Person[] raw_data) {
        try {
            Optional.ofNullable(raw_data).orElseThrow(NullArgumentException::new);
            Map<String, Long> preprocessData = Arrays.stream(raw_data)
                    .filter(Objects::nonNull)
                    .filter(person -> Objects.nonNull(person.getName()))
                    .distinct()
                    .sorted(Comparator.comparingInt(Person::getId))
                    .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

            for (Map.Entry<String, Long> el : preprocessData.entrySet()) {
                System.out.println("Key " + el.getKey());
                System.out.println("Value " + el.getValue());
            }

        } catch (NullArgumentException e) {
            e.printStackTrace();
            System.out.println("null reference passed to method");
        }
    }


    public static void main(String[] args) {
        preprocessing(null);

        preprocessing(RAW_DATA);

    }
}
























