package ru.job4j.condition;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class PointTest {

    @Test
    public void whenPointsAreTheSameThenDistanceIsZero() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 0);
        double expected = 0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void whenDistanceBetweenPointsOnYAxisThenCorrectDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double expected = 2.0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void whenDistanceBetweenPointsOnXAxisThenCorrectDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 0);
        double expected = 3.0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void whenDistanceBetweenDiagonalPointsThenCorrectDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(3, 4);
        double expected = 5.0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void whenDistanceBetweenNegativePointsThenCorrectDistance() {
        Point a = new Point(-1, -1);
        Point b = new Point(-4, -5);
        double expected = 5.0;
        double output = a.distance(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    public void whenDistanceWithDecimalPointsThenCorrectDistance() {
        Point a = new Point(8, 5, 6);
        Point b = new Point(4, 6, 5);
        double expected = 4.0;
        double output = a.distance3d(b);
        assertThat(output).isEqualTo(expected, withPrecision(0.01));
    }
}
