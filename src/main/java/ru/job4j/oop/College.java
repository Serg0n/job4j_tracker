package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman  = new Freshman();
        Student student = freshman;
        Object object = freshman;
        /* Это приведение к классу родителя,
        так как первокурсник является студентом, а так же объектом */
    }
}