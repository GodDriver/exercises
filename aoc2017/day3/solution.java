package ru.goddriver.exercises.aoc2017.day3;

import java.util.HashMap;

public class solution {

    private static int getNumberOfSteps(int input) {
        int x = 0, y = 0;
        int step = 0;
        int number = 1;
        HashMap<Integer, String> map = new HashMap<>();
        map.put(number, "(" + x + "," + y + ")");
        while (number < input) {
            step++;
            for (int i = 1; i <= step; i++) {
                map.put(++number, "(" + (x + i) + "," + y + ")");
            }
            x += step;
            for (int i = 1; i <= step; i++) {
                map.put(++number, "(" + x + "," + (y + i) + ")");
            }
            y += step;
            step++;
            for (int i = 1; i <= step; i++) {
                map.put(++number, "(" + (x - i) + "," + y + ")");
            }
            x -= step;
            for (int i = 1; i <= step; i++) {
                map.put(++number, "(" + x + "," + (y - i) + ")");
            }
            y -= step;
        }
        String[] coord = map.get(input).replaceAll("[()]", "").split(",");
        return Math.abs(Integer.parseInt(coord[0])) + Math.abs(Integer.parseInt(coord[1]));
    }

    private static int getFirstLargerValue(int input) {
        int x = 0, y = 0;
        int step = 0;
        int number = 1;
        int number1 = 0, number2 = 0, number3 = 0, number4 = 0;
        HashMap<String, Integer> map = new HashMap<>();
        map.put("(" + x + "," + y + ")", number);
        while (true) {
            step++;
            for (int i = 1; i <= step; i++) {
                if (map.containsKey("(" + (x + i - 1) + "," + y + ")"))
                    number1 = map.get("(" + (x + i - 1) + "," + y + ")");
                if (map.containsKey("(" + (x + i - 1) + "," + (y + 1) + ")"))
                    number2 = map.get("(" + (x + i - 1) + "," + (y + 1) + ")");
                if (map.containsKey("(" + (x + i) + "," + (y + 1) + ")"))
                    number3 = map.get("(" + (x + i) + "," + (y + 1) + ")");
                if (map.containsKey("(" + (x + i + 1) + "," + (y + 1) + ")"))
                    number4 = map.get("(" + (x + i + 1) + "," + (y + 1) + ")");
                number = number1 + number2 + number3 + number4;
                map.put("(" + (x + i) + "," + y + ")", number);
                if (number >= input)
                    return number;
                number1 = 0;
                number2 = 0;
                number3 = 0;
                number4 = 0;
            }
            x += step;
            for (int i = 1; i <= step; i++) {
                if (map.containsKey("(" + x + "," + (y + i - 1) + ")"))
                    number1 = map.get("(" + x + "," + (y + i - 1) + ")");
                if (map.containsKey("(" + (x - 1) + "," + (y + i - 1) + ")"))
                    number2 = map.get("(" + (x - 1) + "," + (y + i - 1) + ")");
                if (map.containsKey("(" + (x - 1) + "," + (y + i) + ")"))
                    number3 = map.get("(" + (x - 1) + "," + (y + i) + ")");
                if (map.containsKey("(" + (x - 1) + "," + (y + i + 1) + ")"))
                    number4 = map.get("(" + (x - 1) + "," + (y + i + 1) + ")");
                number = number1 + number2 + number3 + number4;
                map.put("(" + x + "," + (y + i) + ")", number);
                if (number >= input)
                    return number;
                number1 = 0;
                number2 = 0;
                number3 = 0;
                number4 = 0;
            }
            y += step;
            step++;
            for (int i = 1; i <= step; i++) {
                if (map.containsKey("(" + (x - i + 1) + "," + y + ")"))
                    number1 = map.get("(" + (x - i + 1) + "," + y + ")");
                if (map.containsKey("(" + (x - i + 1) + "," + (y - 1) + ")"))
                    number2 = map.get("(" + (x - i + 1) + "," + (y - 1) + ")");
                if (map.containsKey("(" + (x - i) + "," + (y - 1) + ")"))
                    number3 = map.get("(" + (x - i) + "," + (y - 1) + ")");
                if (map.containsKey("(" + (x - i - 1) + "," + (y - 1) + ")"))
                    number4 = map.get("(" + (x - i - 1) + "," + (y - 1) + ")");
                number = number1 + number2 + number3 + number4;
                map.put("(" + (x - i) + "," + y + ")", number);
                if (number >= input)
                    return number;
                number1 = 0;
                number2 = 0;
                number3 = 0;
                number4 = 0;
            }
            x -= step;
            for (int i = 1; i <= step; i++) {
                if (map.containsKey("(" + x + "," + (y - i + 1) + ")"))
                    number1 = map.get("(" + x + "," + (y - i + 1) + ")");
                if (map.containsKey("(" + (x + 1) + "," + (y - i + 1) + ")"))
                    number2 = map.get("(" + (x + 1) + "," + (y - i + 1) + ")");
                if (map.containsKey("(" + (x + 1) + "," + (y - i) + ")"))
                    number3 = map.get("(" + (x + 1) + "," + (y - i) + ")");
                if (map.containsKey("(" + (x + 1) + "," + (y - i - 1) + ")"))
                    number4 = map.get("(" + (x + 1) + "," + (y - i - 1) + ")");
                number = number1 + number2 + number3 + number4;
                map.put("(" + x + "," + (y - i) + ")", number);
                if (number >= input)
                    return number;
                number1 = 0;
                number2 = 0;
                number3 = 0;
                number4 = 0;
            }
            y -= step;
        }
    }

    public static void main(String[] args) {
        int puzzleInput = 277678;
        //Part One
        System.out.println(getNumberOfSteps(puzzleInput) + " steps are required");
        //Part Two
        System.out.println("The first value written that is larger than puzzle input is "
                + getFirstLargerValue(puzzleInput));
    }
}