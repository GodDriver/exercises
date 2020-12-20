package ru.goddriver.exercises.aoc2016.day3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static int[] getArrayOfSizes(String line) {
        line = line.replaceAll(" {4}", ",")
                .replaceAll(" {3}", ",")
                .replaceAll(" {2}", ",")
                .replaceFirst(",", "");
        String[] sizes = line.split(",");
        int[] intSizes = new int[3];
        for (int i = 0; i < 3; i++) {
            intSizes[i] = Integer.parseInt(sizes[i]);
        }
        return intSizes;
    }

    private static int getCountPartOne(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        int countPossibleTriangle = 0;
        while (scanner.hasNextLine()) {
            int[] sizes = getArrayOfSizes(scanner.nextLine());
            int a = sizes[0], b = sizes[1], c = sizes[2];
            if ((a + b > c) && (a + c > b) && (b + c > a))
                countPossibleTriangle++;
        }
        scanner.close();
        return countPossibleTriangle;
    }

    private static int getCountPartTwo(String filename) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        int countPossibleTriangle = 0;
        while (scanner.hasNextLine()) {
            int[] sizes1 = getArrayOfSizes(scanner.nextLine());
            int a1 = sizes1[0], b1 = sizes1[1], c1 = sizes1[2];
            int[] sizes2 = getArrayOfSizes(scanner.nextLine());
            int a2 = sizes2[0], b2 = sizes2[1], c2 = sizes2[2];
            int[] sizes3 = getArrayOfSizes(scanner.nextLine());
            int a3 = sizes3[0], b3 = sizes3[1], c3 = sizes3[2];
            if ((a1 + a2 > a3) && (a1 + a3 > a2) && (a2 + a3 > a1))
                countPossibleTriangle++;
            if ((b1 + b2 > b3) && (b1 + b3 > b2) && (b2 + b3 > b1))
                countPossibleTriangle++;
            if ((c1 + c2 > c3) && (c1 + c3 > c2) && (c2 + c3 > c1))
                countPossibleTriangle++;
        }
        scanner.close();
        return countPossibleTriangle;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        System.out.println("The count of possible triangles in Part One are "
                + getCountPartOne(fileName));
        System.out.println("The count of possible triangles in Part Two are "
                + getCountPartTwo(fileName));
    }
}