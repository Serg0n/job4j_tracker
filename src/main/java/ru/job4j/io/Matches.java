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
            turn = !turn;
            if ((matches > 3 || matches < 1) || matches > count)  {
                System.out.println("Пожалуйста введите количество спичек в диапазоне от 1 до 3,"
                        + " а так же не должно быть превышено количество спичек на столе в данный момент: " + count);
                System.out.println(player + " введите число от 1 до 3:");
                matches = Integer.parseInt(input.nextLine());
            }
            count -= matches;
            System.out.println("Количество спичек на столе:" + count);
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}