package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DayTwo.DayTwo;
import org.junit.Test;

public class DayTwoTest {
    DayTwo sln = new DayTwo("Day2.txt");

    @Test
    public void partOne() {
        int expected = 150;
        int actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        int expected = 900;
        int actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
