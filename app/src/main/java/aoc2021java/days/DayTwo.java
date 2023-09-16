package aoc2021java.days;

import aoc2021java.utils.InputReader;
import java.util.ArrayList;

public class DayTwo extends Solution {
    ArrayList<String> input;

    public DayTwo(String inputFile) {
        super(inputFile);
        this.input = InputReader.asLines(inputFile);
    }

    @Override
    public int partOne() {
        int horizontal = 0;
        int depth = 0;

        for (String line : input) {
            String[] parts = line.split(" ", 2);
            String dir = parts[0];
            int speed = Integer.parseInt(parts[1]);

            switch (dir) {
                case "forward":
                    horizontal += speed;
                    break;
                case "down":
                    depth += speed;
                    break;
                case "up":
                    depth -= speed;
                    break;
            }
        }

        return horizontal * depth;
    }

    @Override
    public int partTwo() {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;

        for (String line : input) {
            String[] parts = line.split(" ", 2);
            String dir = parts[0];
            int speed = Integer.parseInt(parts[1]);

            switch (dir) {
                case "forward":
                    horizontal += speed;
                    depth += aim * speed;
                    break;
                case "down":
                    aim += speed;
                    break;
                case "up":
                    aim -= speed;
                    break;
            }
        }

        return horizontal * depth;
    }
}
