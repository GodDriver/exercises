package ru.goddriver.exercises.aoc2020.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static boolean getPartOne(String[] string) {
        int countLetter = 0;
        char letter = string[2].charAt(0);
        for (int i = 0; i < string[3].length(); i++) {
            if (letter == string[3].charAt(i))
                countLetter++;
        }
        return countLetter >= Integer.parseInt(string[0]) && countLetter <= Integer.parseInt(string[1]);
    }

    private static boolean getPartTwo(String[] string) {
        int min = Integer.parseInt(string[0]) - 1, max = Integer.parseInt(string[1]) - 1;
        char letter = string[2].charAt(0);
        return letter == string[3].charAt(min) ^ letter == string[3].charAt(max);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        int countValidPassPartOne = 0, countValidPassPartTwo = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine().replace(":", "")
                    .replaceAll("[ -]",",");
            String[] line = string.split(",");
            if (getPartOne(line))
                countValidPassPartOne++;
            if (getPartTwo(line))
                countValidPassPartTwo++;
        }
        scanner.close();
        System.out.println("Puzzle answer in Part One " + countValidPassPartOne);
        System.out.println("Puzzle answer in Part Two " + countValidPassPartTwo);
    }
}