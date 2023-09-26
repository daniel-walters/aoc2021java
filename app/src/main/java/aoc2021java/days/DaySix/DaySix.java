package aoc2021java.days.DaySix;

import aoc2021java.days.Solution;
import aoc2021java.utils.InputReader;
import java.util.ArrayList;
import java.util.Arrays;

public class DaySix extends Solution<Long> {
    private String input;

    public DaySix(String inputFile) {
        super(inputFile);
        this.input = InputReader.asString(inputFile);
    }

    private ArrayList<Integer> getInitialFish() {
        ArrayList<Integer> initialFish = new ArrayList<>();

        Arrays.stream(this.input.trim().split(","))
            .mapToInt(Integer::parseInt)
            .forEach(i -> initialFish.add(i));

        return initialFish;
    }

    public Long partOne() {
        FishColony colony = new FishColony(this.getInitialFish());
        colony.simulate(80);

        return colony.getNumFish();
    }

    public Long partTwo() {
        FishColony colony = new FishColony(this.getInitialFish());
        colony.simulate(256);

        return colony.getNumFish();
    }
}
