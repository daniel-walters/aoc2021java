package aoc2021java.days;

public abstract class Solution<T extends Number> {
    String inputFile;

    public Solution(String inputFile) {
        this.inputFile = inputFile;
    }

    public abstract T partOne();
    public abstract T partTwo();
}
