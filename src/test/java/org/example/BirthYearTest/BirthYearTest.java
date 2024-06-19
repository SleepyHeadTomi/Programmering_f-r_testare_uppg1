package org.example.BirthYearTest;

import org.example.BirthYear;
import org.junit.Test;

import static org.junit.Assert.*;

public class BirthYearTest {
    @Test
    public void testCalculateBirthYear() {
        int actual = BirthYear.calculateBirthYear("40");
        int expected = 1983;
        assertEquals(expected, actual);
    }
    @Test
    public void testGetGreetingWithValidInputs() {
        String actual = BirthYear.getGreeting("Tim", "21");
        String expected = "Hello Tim! You were born in 2002.";
        assertEquals(expected, actual);
    }
    @Test
    public void testGetGreetingWithInvalidAgeInput() {
        String actual = BirthYear.getGreeting("Tim", "!#");
        String expected = "Invalid age. Must be an integer.";
        assertEquals(expected, actual);
    }
    @Test
    public void testGetGreetingWithInvalidName() {
        String actual = BirthYear.getGreeting("", "40");
        String expected = "Invalid name. Must contain at least one letter.";
        assertEquals(expected, actual);
    }
    @Test
    public void testGetGreetingWithInvalidInputs() {
        String actual = BirthYear.getGreeting("40", "");
        String expected = "Invalid name and age.";
        assertEquals(expected, actual);

        String actual2 = BirthYear.getGreeting(" Tim ", " 21 ");
        String expected2 = "Hello Tim! You were born in 2002.";
        assertEquals(expected2, actual2);
    }
    @Test
    public void testIsValidNumber() {
        assertTrue(BirthYear.isValidNumber("6"));

        assertTrue(BirthYear.isValidNumber("100"));

        assertFalse(BirthYear.isValidNumber("5"));

        assertFalse(BirthYear.isValidNumber("101"));

        assertFalse(BirthYear.isValidNumber("4t"));

        assertFalse(BirthYear.isValidNumber("#!"));

        assertFalse(BirthYear.isValidNumber(""));
    }
    @Test
    public void testIsValidName() {
        assertTrue(BirthYear.isValidName("£T@11"));

        assertTrue(BirthYear.isValidName("Ö"));

        assertFalse(BirthYear.isValidName("40"));

        assertFalse(BirthYear.isValidName(""));
    }
}