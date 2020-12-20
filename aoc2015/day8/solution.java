package ru.goddriver.exercises.aoc2015.day8;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static int getNumberOfCharsForStringLiteral(String string) {
        return string.length();
    }

    private static int getNumberOfCharsInMemoryForValuesOfString (String string) {
        string = string.replace("\\\\", "S");
        string = string.replace("\\\"", "Q");
        string = string.replaceAll("\"", "");
        string = string.replaceAll("\\\\x[0-9a-f]{2}", "X");
        return string.length();
    }

    private static int getNumberOfCharsToRepresentNewlyEncodedStrings (String string) {
        string = string.replace("\\\\", "SSSS");
        string = string.replace("\\\"", "QQQQ");
        string = string.replaceAll("\"", "qqq");
        string = string.replaceAll("\\\\x[0-9a-f]{2}", "XXXXX");
        return string.length();
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int sumPartOne = 0, sumPartTwo = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            sumPartOne += getNumberOfCharsForStringLiteral(string) - getNumberOfCharsInMemoryForValuesOfString(string);
            sumPartTwo += getNumberOfCharsToRepresentNewlyEncodedStrings(string)
                    - getNumberOfCharsForStringLiteral(string);
        }
        scanner.close();
        //Part One
        System.out.println("The number of characters of code for string literals minus the number of characters in " +
                "memory for the values of the strings in total for the entire file is " + sumPartOne);
        //Part Two
        System.out.println("The total number of characters to represent the newly encoded strings minus the number " +
                "of characters of code in each original string literal is " + sumPartTwo);
    }
}