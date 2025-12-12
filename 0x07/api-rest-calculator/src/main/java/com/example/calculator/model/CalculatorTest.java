package com.example.calculator.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void sumTest() {
        assertEquals(7.0, calc.sum(3.0, 4.0));
    }

    @Test
    public void numbersNullSumTest() {
        assertThrows(NullPointerException.class, () -> calc.sum(null, 5.0));
        assertThrows(NullPointerException.class, () -> calc.sum(5.0, null));
    }

    @Test
    void subTest() {
        assertEquals(5.0, calc.sub(10.0, 5.0));
    }

    @Test
    void divideTest() {
        assertEquals(2.5, calc.divide(5.0, 2.0));
    }

    @Test
    public void divisionByZeroTest() {
        assertThrows(ArithmeticException.class, () -> calc.divide(5.0, 0.0));
    }

    @Test
    void factorialTest() {
        assertEquals(120, calc.factorial(5));
        assertEquals(1, calc.factorial(0)); // 0! = 1
    }

    @Test
    void integerToBinaryTest() {
        assertEquals(10100, calc.integerToBinary(20));
        assertEquals(1, calc.integerToBinary(1));
    }

    @Test
    void integerToHexadecimalTest() {
        assertEquals("AA", calc.integerToHexadecimal(170));
        assertEquals("1", calc.integerToHexadecimal(1));
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate d1 = LocalDate.of(2020, 3, 15);
        LocalDate d2 = LocalDate.of(2020, 3, 29);
        assertEquals(14, calc.calculeDayBetweenDate(d1, d2));
    }
}
