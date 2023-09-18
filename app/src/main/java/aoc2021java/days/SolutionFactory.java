package aoc2021java.days;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SolutionFactory {
    private static final Map<Integer, String> classMap = HashMap.newHashMap(25);

    static {
        classMap.put(1, "aoc2021java.days.DayOne");
        classMap.put(2, "aoc2021java.days.DayTwo");
        classMap.put(3, "aoc2021java.days.DayThree");
    }

    public static Solution getDay(int day)
        throws ClassNotFoundException, IllegalAccessException,
               NoSuchMethodException, InstantiationException,
               InvocationTargetException {
        String className = classMap.get(day);

        if (className == null) {
            throw new IllegalArgumentException(
                "No associated class with day " + day);
        }

        Class<?> c = Class.forName(className);
        String inputFile = getFileName(day);

        return (Solution) c.getDeclaredConstructor(String.class)
            .newInstance(inputFile);
    }

    private static String getFileName(int day) {
        return "Day" + day + ".txt";
    }
}
