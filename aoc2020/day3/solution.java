package ru.goddriver.exercises.aoc2020.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class solution {

    public static int getCount(String filename, int right, int down) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        int i = 0, count = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.charAt(i % line.length()) == '#')
                count++;
            i = i + right;
            if (down == 2 && scanner.hasNextLine())
                scanner.nextLine();
        }
        scanner.close();
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        //Part One
        System.out.println("In part one puzzle answer is " + getCount(filename, 3, 1));
        //Part Two
        BigInteger result = BigInteger.ONE;
        result = result
                .multiply(BigInteger.valueOf(getCount(filename, 1, 1)))
                .multiply(BigInteger.valueOf(getCount(filename, 3, 1)))
                .multiply(BigInteger.valueOf(getCount(filename, 5, 1)))
                .multiply(BigInteger.valueOf(getCount(filename, 7, 1)))
                .multiply(BigInteger.valueOf(getCount(filename, 1, 2)));
        System.out.println("In part two puzzle answer is " + result);
    }
}