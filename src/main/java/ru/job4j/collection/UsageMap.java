package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("zark0.n@yandex.ru", "Невский Сергей Александрович");
        map.put("vasya.pupkin@mail.com", "Некрасов Василий Юрьевич");
        map.put("parsentev@yandex.ru", "Arsentev Petr Sergeevich");
        for (String key : map.keySet()) {
            System.out.println("Почта: " + key + ", ФИО: " + map.get(key));
        }
    }
}
