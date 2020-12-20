package ru.goddriver.exercises.aoc2015.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) throws Exception {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int totalSquareFeetOfWrappingPaper = 0;
        int totalFeetOfRibbon = 0;
        while (scanner.hasNextLine()) {
            String[] dimensions = scanner.nextLine().split("x");
            Arrays.sort(dimensions, Comparator.comparing(Integer::valueOf));
            int smallSide = Integer.parseInt(dimensions[0]);
            int middleSide = Integer.parseInt(dimensions[1]);
            int largeSide = Integer.parseInt(dimensions[2]);
            totalSquareFeetOfWrappingPaper += 2 * (smallSide * middleSide + middleSide * largeSide
                    + largeSide * smallSide) + smallSide * middleSide;
            totalFeetOfRibbon += 2 * (smallSide + middleSide) + smallSide * middleSide * largeSide;
        }
        scanner.close();
        //Part One
        System.out.println("Elves should order " + totalSquareFeetOfWrappingPaper + " square feet of wrapping paper");
        //Part Two
        System.out.println("Elves should order " + totalFeetOfRibbon + " feet of ribbon");
    }
}