package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class StringCompareTest {
    @Test
    public void whenStringsAreEqualThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanov"
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenLeftLessThanRightResultShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "Ivanova"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftGreaterThanRightResultShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Ivanova"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftGreaterThanRightShouldBePositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Petrov",
                "Patrov"
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void secondCharOfLeftLessThanRightShouldBeNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Patrova",
                "Petrov"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenLeftIsEmptyAndRightIsNotThenNegative() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                "NonEmpty"
        );
        assertThat(result).isLessThan(0);
    }

    @Test
    public void whenRightIsEmptyAndLeftIsNotThenPositive() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "NonEmpty",
                ""
        );
        assertThat(result).isGreaterThan(0);
    }

    @Test
    public void whenBothStringsAreEmptyThenZero() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "",
                ""
        );
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void whenStringsDifferInCaseThenCompareCaseSensitively() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Ivanov",
                "ivanov"
        );
        assertThat(result).isLessThan(0); // Заглавная буква меньше строчной
    }

    @Test
    public void whenPrefixIsTheSameThenCompareByLength() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Test",
                "Testing"
        );
        assertThat(result).isLessThan(0); // "Test" короче, чем "Testing"
    }

    @Test
    public void whenFirstCharDiffersThenCompareByFirstChar() {
        StringCompare compare = new StringCompare();
        int result = compare.compare(
                "Apple",
                "Banana"
        );
        assertThat(result).isLessThan(0); // 'A' меньше 'B'
    }
}
