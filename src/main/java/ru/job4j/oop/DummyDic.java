package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово. " + eng;
    }

    public static void main(String[] args) {
        DummyDic eng = new DummyDic();
        String translate = eng.engToRus("DummyDic");
        System.out.println(translate);
    }
}
