package ru.job4j.condition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MaxTest {

    @Test
    public void whenMaxOfTwoNumbers() {
        assertEquals(6, Max.max(4, 6));
        assertEquals(5, Max.max(5, 3));
        assertEquals(-1, Max.max(-3, -1));
        assertEquals(0, Max.max(0, 0));
    }

    @Test
    public void whenMaxOfThreeNumbers() {
        assertEquals(8, Max.max(4, 6, 8));
        assertEquals(9, Max.max(9, 5, 3));
        assertEquals(0, Max.max(-1, 0, -2));
        assertEquals(7, Max.max(7, 7, 7));
    }

    @Test
    public void whenMaxOfFourNumbers() {
        assertEquals(10, Max.max(6, 8, 1, 10));
        assertEquals(15, Max.max(12, 15, 10, 7));
        assertEquals(0, Max.max(-3, -2, -5, 0));
        assertEquals(-1, Max.max(-1, -1, -1, -1));
    }
}