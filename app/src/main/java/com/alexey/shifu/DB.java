package com.alexey.shifu;

import java.util.ArrayList;
import java.util.List;

public class DB {

    static List<String> firstValues = new ArrayList<>();
    static List<String> secondValues = new ArrayList<>();

    public static void add(String firstValue, String secondValue) {
        firstValues.add(firstValue);
        secondValues.add(secondValue);
    }

    public static String getFirstValue(int index) {
        return firstValues.get(index);
    }

    public static String getSecondValue(int index) {
        return secondValues.get(index);
    }
}
