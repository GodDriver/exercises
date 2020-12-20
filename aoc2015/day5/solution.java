package ru.goddriver.exercises.aoc2015.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static boolean getStringNotContains(String string) {
        String[] notContains = {"ab", "cd", "pq", "xy"};
        int countNotContains = 0;
        for (String notContain : notContains) {
            if (string.contains(notContain))
                countNotContains++;
        }
        return countNotContains == 0;
    }

    private static boolean getStringContainsThreeVowels(String string) {
        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int countVowel = 0;
        for (char vowel : vowels) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == vowel)
                    countVowel++;
            }
        }
        return countVowel >= 3;
    }

    private static boolean getDoubleLetters(String string) {
        int countDoubleLetters = 0;
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1))
                countDoubleLetters++;
        }
        return countDoubleLetters > 0;
    }

    private static int getCountNiceString(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int count = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (getStringNotContains(string) && getStringContainsThreeVowels(string) && getDoubleLetters(string))
                count++;
        }
        scanner.close();
        return count;
    }

    private static boolean getContainsPairOfTwoLetters(String string) {
        int countPairOfTwoLetters = 0;
        for (int i = 0; i < string.length() - 3; i++) {
            for (int k = 0; k < string.length(); k++) {
                if (i + k < string.length() - 3) {
                    if (string.charAt(i) == string.charAt(i + 2 + k)
                            && string.charAt(i + 1) == string.charAt(i + 3 + k))
                        countPairOfTwoLetters++;
                }
            }
        }
        return countPairOfTwoLetters > 0;
    }

    private static boolean getRepeatsLetterWithOneLetterBetweenThem(String string) {
        int countRepeatsLetter = 0;
        for (int i = 0; i < string.length() - 2; i++) {
            if (string.charAt(i) == string.charAt(i + 2))
                countRepeatsLetter++;
        }
        return countRepeatsLetter > 0;
    }

    private static int getCountNiceStringNewRules(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int count = 0;
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (getContainsPairOfTwoLetters(string) && getRepeatsLetterWithOneLetterBetweenThem(string))
                count++;
        }
        scanner.close();
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        //Part One
        System.out.println("Number of nice strings is " + getCountNiceString(fileName));
        //Part Two
        System.out.println("Number of nice strings under new rules is " + getCountNiceStringNewRules(fileName));
    }
}