package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese{
    private static final String tomato = "extra tomato";
    public String name() {
        return super.name() + " + " + tomato;
    }
}
