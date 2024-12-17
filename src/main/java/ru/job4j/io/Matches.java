package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;

        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());

            if (matches < 1 || matches > 3) {
                System.out.println("Ошибка: нужно ввести число от 1 до 3.");
            } else if (matches > count) {
                System.out.println("Ошибка: нельзя брать больше спичек, чем осталось на столе: " + count);
            } else {
                count -= matches;
                System.out.println("Количество спичек на столе: " + count);
                turn = !turn;
            }
        }

        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}