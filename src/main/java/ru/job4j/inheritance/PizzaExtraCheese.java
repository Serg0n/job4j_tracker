package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    private static final String CHESE = "extra chese";

    @Override
    public String name() {
        return super.name() + " + " + CHESE;
    }
}