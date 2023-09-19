package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DayFour.DayFour;
import org.junit.Test;

public class DayFourTest {
    DayFour sln = new DayFour("Day4.txt");

    @Test
    public void partOne() {
        int expected = 4512;
        int actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        int expected = 1924;
        int actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
