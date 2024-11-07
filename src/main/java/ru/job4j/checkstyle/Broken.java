package ru.job4j.checkstyle;

public class Broken {
    private int sizeOfEmpty = 10;
    String name;
    private String surname;
    public static final String NEW_VALUE = "";

    public Broken() {
    }

    public void echo() {
    }

    public void media(Object object) {
        if (object != null) {
            System.out.println(object);
        }
    }

    public void method(int a, int b, int c, int d, int e, int f, int g) {

    }
}