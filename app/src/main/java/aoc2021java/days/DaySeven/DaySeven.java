package aoc2021java.days.DaySeven;

import aoc2021java.days.Solution;
import aoc2021java.utils.InputReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DaySeven extends Solution<Integer> {
    String input;

    public DaySeven(String inputFile) {
        super(inputFile);
        this.input = InputReader.asString(inputFile);
    }

    private ArrayList<Integer> parseInput() {
        ArrayList<Integer> list = new ArrayList<>();

        int[] nums = Arrays.stream(this.input.trim().split(","))
                         .mapToInt(Integer::parseInt)
                         .toArray();

        for (int i : nums) {
            list.add(i);
        }

        return list;
    }

    public Integer partOne() {
        ArrayList<Integer> list = this.parseInput();
        Collections.sort(list);
        int median;
        int fuel = 0;

        if (list.size() % 2 == 0) {
            int left = list.get(list.size() / 2 - 1);
            int right = list.get(list.size() / 2);

            median = (left + right) / 2;
        } else {
            median = list.get(list.size() / 2);
        }

        for (int i : list) {
            fuel += Math.abs(i - median);
        }

        return fuel;
    }

    public Integer partTwo() {
        return 0;
    }
}
