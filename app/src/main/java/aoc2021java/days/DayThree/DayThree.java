package aoc2021java.days.DayThree;

import aoc2021java.days.Solution;
import aoc2021java.utils.InputReader;
import java.util.ArrayList;

public class DayThree extends Solution<Integer> {
    ArrayList<String> input;

    public DayThree(String inputFile) {
        super(inputFile);
        this.input = InputReader.asLines(inputFile);
    }

    private char getMostCommon(ArrayList<Character> charList) {
        int numZeros = 0;
        int numOnes = 0;

        for (char ch : charList) {
            if (ch == '1') {
                numOnes++;
            } else {
                numZeros++;
            }
        }

        return numOnes >= numZeros ? '1' : '0';
    }

    private char getLeastCommon(ArrayList<Character> charList) {
        int numZeros = 0;
        int numOnes = 0;

        for (char ch : charList) {
            if (ch == '1') {
                numOnes++;
            } else {
                numZeros++;
            }
        }

        return numOnes >= numZeros ? '0' : '1';
    }

    private String invertBinary(String bin) {
        String inverted = "";

        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) == '0') {
                inverted += "1";
            } else {
                inverted += "0";
            }
        }

        return inverted;
    }

    @Override
    public Integer partOne() {
        String gamma = "";

        for (int i = 0; i < this.input.get(0).length(); i++) {
            ArrayList<Character> nDigits = new ArrayList<>();

            for (String line : this.input) {
                nDigits.add(line.charAt(i));
            }

            gamma += this.getMostCommon(nDigits);
        }

        String epsilon = this.invertBinary(gamma);

        return Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
    }

    @Override
    public Integer partTwo() {
        ArrayList<String> o2 = new ArrayList<>(this.input);
        ArrayList<String> co2 = new ArrayList<>(this.input);

        for (int i = 0; i < this.input.get(0).length(); i++) {
            int idx = i;

            if (o2.size() > 1) {
                ArrayList<Character> nDigits = new ArrayList<>();

                for (String line : o2) {
                    nDigits.add(line.charAt(idx));
                }
                char mostCommon = this.getMostCommon(nDigits);

                o2.removeIf(
                    (String bin) -> { return bin.charAt(idx) != mostCommon; });
            }

            if (co2.size() > 1) {
                ArrayList<Character> nDigits = new ArrayList<>();

                for (String line : co2) {
                    nDigits.add(line.charAt(idx));
                }

                char leastCommon = this.getLeastCommon(nDigits);

                co2.removeIf(
                    (String bin) -> { return bin.charAt(idx) != leastCommon; });
            }
        }

        return Integer.parseInt(o2.get(0), 2) * Integer.parseInt(co2.get(0), 2);
    }
}
