package ru.goddriver.exercises.aoc2016.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static int movePartOne(int previousButton, char direction) {
        if (((previousButton == 1 || previousButton == 4) && direction == 'U')
            || ((previousButton == 1 || previousButton == 2) && direction == 'L'))
            return 1;
        else if (((previousButton == 2 || previousButton == 5) && direction == 'U')
                || (previousButton == 3 && direction == 'L')
                || (previousButton == 1 && direction == 'R'))
            return 2;
        else if (((previousButton == 3 || previousButton == 6) && direction == 'U')
                || ((previousButton == 3 || previousButton == 2) && direction == 'R'))
            return 3;
        else if (((previousButton == 4 || previousButton == 5) && direction == 'L')
                || (previousButton == 1 && direction == 'D')
                || (previousButton == 7 && direction == 'U'))
            return 4;
        else if ((previousButton == 8 && direction == 'U')
                || (previousButton == 6 && direction == 'L')
                || (previousButton == 4 && direction == 'R')
                || (previousButton == 2 && direction == 'D'))
            return 5;
        else if (((previousButton == 6 || previousButton == 5) && direction == 'R')
                || (previousButton == 9 && direction == 'U')
                || (previousButton == 3 && direction == 'D'))
            return 6;
        else if (((previousButton == 7 || previousButton == 4) && direction == 'D')
                || ((previousButton == 7 || previousButton == 8) && direction == 'L'))
            return 7;
        else if (((previousButton == 8 || previousButton == 5) && direction == 'D')
                || (previousButton == 9 && direction == 'L')
                || (previousButton == 7 && direction == 'R'))
            return 8;
        else
            return 9;
    }

    private static int movePartTwo(int previousButton, char direction) {
        if ((previousButton == 1 && (direction == 'U' || direction == 'L' || direction =='R'))
            || (previousButton == 3 && direction == 'U'))
            return 1;
        else if (((previousButton == 2 || previousButton == 6) && direction == 'U')
                || ((previousButton == 2 || previousButton == 3) && direction == 'L'))
            return 2;
        else if ((previousButton == 7 && direction == 'U')
                || (previousButton == 4 && direction == 'L')
                || (previousButton == 2 && direction == 'R')
                || (previousButton == 1 && direction == 'D'))
            return 3;
        else if (((previousButton == 4 || previousButton == 8) && direction == 'U')
                || ((previousButton == 3 || previousButton == 4) && direction == 'R'))
            return 4;
        else if ((previousButton == 5 && (direction == 'U' || direction == 'L' || direction =='D'))
                || (previousButton == 6 && direction == 'L'))
            return 5;
        else if ((previousButton == 10 && direction == 'U')
                || (previousButton == 7 && direction == 'L')
                || (previousButton == 5 && direction == 'R')
                || (previousButton == 2 && direction == 'D'))
            return 6;
        else if ((previousButton == 11 && direction == 'U')
                || (previousButton == 8 && direction == 'L')
                || (previousButton == 6 && direction == 'R')
                || (previousButton == 3 && direction == 'D'))
            return 7;
        else if ((previousButton == 12 && direction == 'U')
                || (previousButton == 9 && direction == 'L')
                || (previousButton == 7 && direction == 'R')
                || (previousButton == 4 && direction == 'D'))
            return 8;
        else if ((previousButton == 9 && (direction == 'U' || direction == 'R' || direction =='D'))
                || (previousButton == 8 && direction == 'R'))
            return 9;
        else if (((previousButton == 10 || previousButton == 11) && direction == 'L')
                || ((previousButton == 6 || previousButton == 10) && direction == 'D'))
            return 10;
        else if ((previousButton == 13 && direction == 'U')
                || (previousButton == 12 && direction == 'L')
                || (previousButton == 10 && direction == 'R')
                || (previousButton == 7 && direction == 'D'))
            return 11;
        else if (((previousButton == 11 || previousButton == 12) && direction == 'R')
                || ((previousButton == 8 || previousButton == 12) && direction == 'D'))
            return 12;
        else
            return 13;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int buttonPartOne = 5;
        int buttonPartTwo = 5;
        StringBuilder theBathroomCodePartOne = new StringBuilder();
        StringBuilder theBathroomCodePartTwo = new StringBuilder();
        while (scanner.hasNextLine()) {
            String instruction = scanner.nextLine();
            for (int i = 0; i < instruction.length(); i++) {
                buttonPartOne = movePartOne(buttonPartOne, instruction.charAt(i));
                buttonPartTwo = movePartTwo(buttonPartTwo, instruction.charAt(i));
                if (i == instruction.length() - 1) {
                    theBathroomCodePartOne.append(buttonPartOne);
                    theBathroomCodePartTwo.append(Integer.toHexString(buttonPartTwo).toUpperCase());
                }
            }
        }
        scanner.close();
        System.out.println("The correct bathroom code in Part One is " + theBathroomCodePartOne);
        System.out.println("The correct bathroom code in Part Two is " + theBathroomCodePartTwo);
    }
}