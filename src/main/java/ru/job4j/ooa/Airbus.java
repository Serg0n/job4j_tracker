package ru.job4j.ooa;

public  class Airbus extends Aircraft {
    private static final int COUNT_ENGINE = 2;

    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public void printModel() {
        System.out.println("Модель самолета: " + name);
    }

    public void printCountEngine() {
            int count = name.equals("A380") ? 4 : COUNT_ENGINE;
            System.out.println("Количество двигателей равно: " + count);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}