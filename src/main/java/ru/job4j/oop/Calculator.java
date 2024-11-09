package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + divide(y);
    }

    public static void main(String[] args) {
        int resultSum = Calculator.sum(10);
        System.out.println("y + x = " + resultSum);
        int resultMinus = Calculator.minus(10);
        System.out.println("y - x = " + resultMinus);
        Calculator divide = new Calculator();
        int resultDivide = divide.divide(10);
        System.out.println("y / x = " + resultDivide);
        Calculator sumAllOperation = new Calculator();
        int resultSumAllOperation = sumAllOperation.sumAllOperation(10);
        System.out.println("Сумма всех операций = " + resultSumAllOperation);
    }
}