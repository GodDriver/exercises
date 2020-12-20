package ru.goddriver.exercises.aoc2017.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class solution {

    public static void main(String[] args) throws IOException {
        String fileName = "input";
        String puzzleInput = (new BufferedReader(new FileReader(fileName))).readLine();
        int num1, num2;
        int theSolution = 0;
        //Part One
        for (int i = 0; i < puzzleInput.length() - 1; i++) {
            num1 = Integer.parseInt(String.valueOf(puzzleInput.charAt(i)));
            num2 = Integer.parseInt(String.valueOf(puzzleInput.charAt(i + 1)));
            if (num1 == num2) {
                theSolution += num1;
            }
        }
        num1 = Integer.parseInt(String.valueOf(puzzleInput.charAt(0)));
        num2 = Integer.parseInt(String.valueOf(puzzleInput.charAt(puzzleInput.length() - 1)));
        if (num1 == num2) {
            theSolution += num1;
        }
        System.out.println("The solution to captcha is " + theSolution);
        //Part Two
        theSolution = 0;
        for (int i = 0; i < puzzleInput.length() / 2; i++) {
            num1 = Integer.parseInt(String.valueOf(puzzleInput.charAt(i)));
            num2 = Integer.parseInt(String.valueOf(puzzleInput.charAt(i + puzzleInput.length() / 2)));
            if (num1 == num2) {
                theSolution += num1 + num2;
            }
        }
        System.out.println("The solution to new captcha is " + theSolution);
    }
}