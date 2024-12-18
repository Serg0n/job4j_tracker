package ru.job4j.polymorphism;

public class Bus implements Transport {

    @Override
    public void move() {
        System.out.println("Едет по дороге");
    }

    @Override
    public void passengers() {
        int passengerSeats = 50;
        System.out.println("Перевозит " + passengerSeats + " пассажиров");
    }

    @Override
    public int refuel(int fuel) {
        int fuelCost = 25;
        int cost = fuel * fuelCost;
        System.out.println("Заправлено " + fuel + " литров топлива на сумму " + cost + " рублей");
        return cost;
    }
}