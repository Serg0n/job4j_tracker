package ru.job4j.tracker;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class ItemTest {
    @Test
    public void testSortAscByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Zebra"));
        items.add(new Item(2, "Apple"));
        items.add(new Item(3, "Orange"));
        List<Item> expected = new ArrayList<>(items);
        Collections.sort(expected, new Item.ItemAscByName());
        Collections.sort(items, new Item.ItemAscByName());
        assertEquals(expected, items);
    }

    @Test
    public void testSortDescByName() {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1, "Zebra"));
        items.add(new Item(2, "Apple"));
        items.add(new Item(3, "Orange"));
        List<Item> expected = new ArrayList<>(items);
        Collections.sort(expected, new Item.ItemDescByName());
        Collections.sort(items, new Item.ItemDescByName());
        assertEquals(expected, items);
    }
}