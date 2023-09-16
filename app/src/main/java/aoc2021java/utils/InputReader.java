package aoc2021java.utils;

import aoc2021java.App;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
    private Scanner readFile(String fileName) {
        InputStream stream =
            App.class.getClassLoader().getResourceAsStream(fileName);

        return new Scanner(stream);
    }

    public static ArrayList<Integer> asInts(String fileName) {
        ArrayList<Integer> list = new ArrayList<>();
        Scanner s = new InputReader().readFile(fileName);

        while (s.hasNextInt()) {
            list.add(s.nextInt());
        }

        s.close();

        return list;
    }

    public static ArrayList<String> asLines(String fileName) {
        ArrayList<String> list = new ArrayList<>();
        Scanner s = new InputReader().readFile(fileName);

        while (s.hasNextLine()) {
            list.add(s.nextLine());
        }

        s.close();

        return list;
    }
}
