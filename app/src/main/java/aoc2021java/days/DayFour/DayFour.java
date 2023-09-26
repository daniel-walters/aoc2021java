package aoc2021java.days.DayFour;

import aoc2021java.days.Solution;
import aoc2021java.utils.InputReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DayFour extends Solution<Integer> {
    String input;

    public DayFour(String inputFile) {
        super(inputFile);
        this.input = InputReader.asString(inputFile);
    }

    private ArrayList<Integer> convertNumbersToList(String numbers) {
        ArrayList<Integer> out = new ArrayList<>();

        for (String num : numbers.split(",")) {
            out.add(Integer.parseInt(num));
        }

        return out;
    }

    @Override
    public Integer partOne() {
        LinkedList<String> parts =
            new LinkedList<>(Arrays.asList(this.input.split("\n\n")));

        ArrayList<BingoBoard> boards = new ArrayList<>();
        ArrayList<Integer> numbers =
            this.convertNumbersToList(parts.removeFirst());

        for (String board : parts) {
            boards.add(new BingoBoard(board));
        }

        for (Integer num : numbers) {
            for (BingoBoard board : boards) {
                boolean win = board.markNum(num);
                if (win) {
                    return board.getScore() * num;
                }
            }
        }

        return -1;
    }

    @Override
    public Integer partTwo() {
        LinkedList<String> parts =
            new LinkedList<>(Arrays.asList(this.input.split("\n\n")));

        ArrayList<BingoBoard> boards = new ArrayList<>();
        ArrayList<Integer> numbers =
            this.convertNumbersToList(parts.removeFirst());

        for (String board : parts) {
            boards.add(new BingoBoard(board));
        }

        int score = 0;

        for (Integer num : numbers) {
            for (BingoBoard board : boards) {
                if (board.getFinished()) {
                    continue;
                }

                boolean win = board.markNum(num);
                if (win) {
                    score = board.getScore() * num;
                }
            }
        }

        return score;
    }
}
