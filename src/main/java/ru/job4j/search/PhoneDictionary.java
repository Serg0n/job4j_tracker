package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список пользователей, которые прошли проверку.
     */
    /*public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getName().contains(key) || person.getPhone().contains(key)
                    || person.getSurname().contains(key) || person.getAddress().contains(key)) {
                result.add(person);
            }


        return result;
    }}*/

    public ArrayList<Person> find(String key) {
        Predicate<Person> matchName = p -> p.getName().contains(key);
        Predicate<Person> matchPhone = p -> p.getPhone().contains(key);
        Predicate<Person> matchSurname = p -> p.getSurname().contains(key);
        Predicate<Person> matchAddress = p -> p.getAddress().contains(key);
        var combine = matchName.or(matchPhone).or(matchSurname).or(matchAddress);
        var result = new ArrayList<Person>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}