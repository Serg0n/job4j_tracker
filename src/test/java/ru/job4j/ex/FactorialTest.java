package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {

    @Test
    public void whenNegativeNumberThenThrowException() {
        Factorial factorial = new Factorial();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calc(-1)
        );
        assertThat(exception.getMessage()).isEqualTo("Number could not be less than 0");
    }

    @Test
    public void whenPositiveNumberThenThrowException() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(5);
        assertThat(result).isEqualTo(120);
    }
}
