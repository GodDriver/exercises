package ru.goddriver.exercises.aoc2015.day10;

public class solution {

    private static String getLookAndSay(String puzzle) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        for (int i = 0; i < puzzle.length() - 1; i++) {
            if (puzzle.charAt(i) == puzzle.charAt(i + 1))
                count++;
            else {
                output.append(count);
                output.append(puzzle.charAt(i));
                count = 1;
            }
        }
        output.append(count);
        output.append(puzzle.charAt(puzzle.length() - 1));
        return output.toString();
    }

    private static String getNTimes(String puzzle, int n) {
        for (int i = 0; i < n; i++) {
            puzzle = getLookAndSay(puzzle);
        }
        return puzzle;
    }

    public static void main(String[] args) {
        String input = "1113222113";
        //Part one
        System.out.println("The length of the result is " + getNTimes(input, 40).length());
        //Part Two
        System.out.println("The length of the new result is " + getNTimes(input, 50).length());
    }
}