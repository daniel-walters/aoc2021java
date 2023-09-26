package aoc2021java;

import static org.junit.Assert.*;

import aoc2021java.days.DaySix.DaySix;
import org.junit.Test;

public class DaySixTest {
    DaySix sln = new DaySix("Day6.txt");

    @Test
    public void partOne() {
        long expected = 5934L;
        long actual = sln.partOne();

        assertEquals(expected, actual);
    }

    @Test
    public void partTwo() {
        long expected = 26984457539L;
        long actual = sln.partTwo();

        assertEquals(expected, actual);
    }
}
