package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DayThree.DayThree;
import org.junit.Test;

public class DayThreeTest {
    DayThree sln = new DayThree("Day3.txt");

    @Test
    public void partOne() {
        int expected = 198;
        int actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        int expected = 230;
        int actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
