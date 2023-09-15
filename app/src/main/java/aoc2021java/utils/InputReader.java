package aoc2021java.utils;

import aoc2021java.App;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class InputReader {
  private InputStream readFile(String fileName) {
    InputStream stream = App.class.getClassLoader().getResourceAsStream(fileName);

    return stream;
  }

  public static ArrayList<Integer> asInts(String fileName) {
    ArrayList<Integer> list = new ArrayList<>();
    Scanner s = new Scanner(new InputReader().readFile(fileName));

    while (s.hasNextInt()) {
      list.add(s.nextInt());
    }

    s.close();

    return list;
  }
}
