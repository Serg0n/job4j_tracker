package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String cheese = "extra chese";
    @Override
    public String name() {
        return super.name() + " + " + cheese;
    }
}