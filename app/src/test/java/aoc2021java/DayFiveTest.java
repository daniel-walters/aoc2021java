package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DayFive.DayFive;
import org.junit.Test;

public class DayFiveTest {
    DayFive sln = new DayFive("Day5.txt");

    @Test
    public void partOne() {
        int expected = 5;
        int actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        int expected = 12;
        int actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
