package aoc2021java.days;

public abstract class Solution {
    String inputFile;

    public Solution(String inputFile) {
        this.inputFile = inputFile;
    }

    public abstract int partOne();
    public abstract int partTwo();
}
