package aoc2021java.days;

import aoc2021java.utils.InputReader;
import java.util.ArrayList;

public class DayOne extends Solution {
    ArrayList<Integer> input;

    public DayOne(String inputFile) {
        super(inputFile);
        this.input = InputReader.asInts(inputFile);
    }

    @Override
    public int partOne() {
        int numIncreases = 0;
        int prev = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            int cur = input.get(i);

            if (cur > prev) {
                numIncreases++;
            }

            prev = cur;
        }

        return numIncreases;
    }

    @Override
    public int partTwo() {
        int numIncreases = 0;
        int prev = input.get(0) + input.get(1) + input.get(2);

        for (int i = 3; i < input.size(); i++) {
            int cur = input.get(i) + input.get(i - 1) + input.get(i - 2);

            if (cur > prev) {
                numIncreases++;
            }

            prev = cur;
        }

        return numIncreases;
    }
}
