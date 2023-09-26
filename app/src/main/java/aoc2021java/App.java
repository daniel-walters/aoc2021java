package aoc2021java;

import aoc2021java.days.Solution;
import aoc2021java.days.SolutionFactory;

public class App {
    private int processArgs(String[] args) throws IllegalArgumentException {
        final String USAGE = "Usage: --day=<int>";

        String dayArg, day;

        if (args.length < 1) {
            throw new IllegalArgumentException("1 argument required. " + USAGE);
        }

        dayArg = args[0];

        if (!dayArg.matches("--day=[0-9]+")) {
            throw new IllegalArgumentException("Invalid argument. " + USAGE);
        }

        day = dayArg.substring(dayArg.length() - 1);

        return Integer.parseInt(day);
    }

    public static void main(String[] args) {
        App app = new App();
        int day = -1;

        try {
            day = app.processArgs(args);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }

        try {
            Solution<?> sln = SolutionFactory.getDay(day);
            System.out.println("Part One: " + sln.partOne());
            System.out.println("Part Two: " + sln.partTwo());
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}
