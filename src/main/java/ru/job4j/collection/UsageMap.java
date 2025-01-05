package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("zark0.n@yandex.ru", new ArrayList<>());
        map.get("zark0.n@yandex.ru").add("Сергей");
        map.get("zark0.n@yandex.ru").add("Невский Сергей Александрович");

        map.put("vasya.pupkin@mail.com", new ArrayList<>());
        map.get("vasya.pupkin@mail.com").add("Некрасов Василий Юрьевич");

        map.put("parsentev@yandex.ru", new ArrayList<>());
        map.get("parsentev@yandex.ru").add("Petr");
        map.get("parsentev@yandex.ru").add("Arsentev Petr Sergeevich");

        for (String key : map.keySet()) {
            System.out.println("Почта: " + key + ", ФИО: " + map.get(key));
        }
    }
}
