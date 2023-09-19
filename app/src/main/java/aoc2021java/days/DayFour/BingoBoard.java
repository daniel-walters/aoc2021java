package aoc2021java.days.DayFour;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BingoBoard {
    private List<List<Integer>> board;
    private boolean finished = false;

    public BingoBoard(String rawBoard) {
        List<List<Integer>> board = new ArrayList<>();
        String[] rows = rawBoard.split("\n");

        for (String row : rows) {
            List<Integer> nums = new ArrayList<>(Arrays.asList(row.split(" ")))
                                     .stream()
                                     .filter((s) -> !s.equals(""))
                                     .map(Integer::parseInt)
                                     .collect(Collectors.toList());

            board.add(nums);
        }

        this.board = board;
    }

    public boolean markNum(Integer num) {
        for (int i = 0; i < this.board.size(); i++) {
            List<Integer> row = this.board.get(i);

            for (int j = 0; j < row.size(); j++) {
                Integer val = row.get(j);

                if (val == num) {
                    row.set(j, -1);
                    return this.checkWinFrom(i, j);
                }
            }
        }

        return false;
    }

    public boolean checkWinFrom(int rowIdx, int numIdx) {
        List<Integer> targetRow = this.board.get(rowIdx);

        if (targetRow.stream().allMatch((i) -> i == -1)) {
            this.finished = true;
            return true;
        }

        for (List<Integer> row : this.board) {
            if (row.get(numIdx) != -1) {
                return false;
            }
        }

        this.finished = true;
        return true;
    }

    public int getScore() {
        int sum = 0;

        for (List<Integer> row : this.board) {
            for (Integer num : row) {
                if (num > -1) {
                    sum += num;
                }
            }
        }

        return sum;
    }

    public boolean getFinished() {
        return this.finished;
    }
}
