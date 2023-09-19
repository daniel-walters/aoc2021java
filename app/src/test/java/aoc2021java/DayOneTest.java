package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DayOne.DayOne;
import org.junit.Test;

public class DayOneTest {
    DayOne sln = new DayOne("Day1.txt");

    @Test
    public void partOne() {
        int expected = 7;
        int actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        int expected = 5;
        int actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
