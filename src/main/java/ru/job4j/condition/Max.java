package ru.job4j.condition;

public class Max {
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return max(a,
                max(b, c));
    }

    public static int max(int a, int b, int c, int d) {
        return max(max(a, b, c), d);
    }

    public static void main(String[] args) {
        System.out.println(max(4, 6, 8));
        System.out.println(max(6, 8, 1, 10));
    }
}
