package aoc2021java.days.DayFive;

import aoc2021java.days.Solution;
import aoc2021java.utils.InputReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DayFive extends Solution<Integer> {
    ArrayList<String> input;

    public DayFive(String inputFile) {
        super(inputFile);
        this.input = InputReader.asLines(inputFile);
    }

    private ArrayList<String> getPointsOnLine(
        int startX, int startY, int endX, int endY, boolean includeDiagonals) {
        ArrayList<String> points = new ArrayList<>();

        if (startX == endX) {
            int minY = Math.min(startY, endY);
            int maxY = Math.max(startY, endY);

            for (int i = minY; i <= maxY; i++) {
                points.add(startX + "-" + i);
            }
        } else if (startY == endY) {
            int minX = Math.min(startX, endX);
            int maxX = Math.max(startX, endX);

            for (int i = minX; i <= maxX; i++) {
                points.add(i + "-" + startY);
            }
        } else if (includeDiagonals) {
            for (int i = 0; i < 1 + Math.abs(startX - endX); i++) {
                int y = startY > endY ? startY - i : startY + i;
                int x = startX > endX ? startX - i : startX + i;

                points.add(x + "-" + y);
            }
        }
        return points;
    }

    @Override
    public Integer partOne() {
        Map<String, Integer> pointMap = new HashMap<>();

        for (String line : this.input) {
            int[] parts =
                Arrays.stream(line.split(" -> "))
                    .map(s -> s.split(","))
                    .flatMapToInt(
                        l -> Arrays.stream(l).mapToInt(Integer::parseInt))
                    .toArray();

            ArrayList<String> pointsToAdd = this.getPointsOnLine(
                parts[0], parts[1], parts[2], parts[3], false);

            for (String point : pointsToAdd) {
                if (pointMap.containsKey(point)) {
                    int cur = pointMap.get(point);
                    pointMap.put(point, cur + 1);
                } else {
                    pointMap.put(point, 1);
                }
            }
        }

        return (int) pointMap.values().stream().filter(i -> i > 1).count();
    }

    @Override
    public Integer partTwo() {
        Map<String, Integer> pointMap = new HashMap<>();

        for (String line : this.input) {
            int[] parts =
                Arrays.stream(line.split(" -> "))
                    .map(s -> s.split(","))
                    .flatMapToInt(
                        l -> Arrays.stream(l).mapToInt(Integer::parseInt))
                    .toArray();

            ArrayList<String> pointsToAdd = this.getPointsOnLine(
                parts[0], parts[1], parts[2], parts[3], true);

            for (String point : pointsToAdd) {
                if (pointMap.containsKey(point)) {
                    int cur = pointMap.get(point);
                    pointMap.put(point, cur + 1);
                } else {
                    pointMap.put(point, 1);
                }
            }
        }

        return (int) pointMap.values().stream().filter(i -> i > 1).count();
    }
}
