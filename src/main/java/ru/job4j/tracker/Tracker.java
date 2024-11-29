package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        int size = 0;
        Item[] result = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                result[size] = name;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        for (int index = 0; index < result.length; index++) {
            System.out.println(result[index]);
        }
        return result;
    }

    public Item[] findByName(String key) {
        int size = 0;
        Item[] result = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            if (items[index] != null && key.equals(items[index].getName())) {
                result[size] = items[index];
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        for (Item item : result) {
            System.out.println(item != null ? item.getName() : "null");
        }
        return result;
    }

    public Item findById(int id) {
        Item result = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                result = item;
                break;
            }
        }
        return result;
    }
}