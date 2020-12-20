package ru.goddriver.exercises.aoc2015.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    public static int getCountLitLights(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int countLitLights = 0;
        int[][] grid = new int[1000][1000];
        String stringInstruction;
        String[] instruction;
        while (scanner.hasNextLine()) {
            stringInstruction = scanner.nextLine();
            if (stringInstruction.startsWith("turn")) {
                stringInstruction = stringInstruction.replaceFirst(" ", "");
            }
            instruction = stringInstruction.replace(" ", ",").split(",");
            for (int i = Integer.parseInt(instruction[2]); i <= Integer.parseInt(instruction[5]); i++) {
                for (int j = Integer.parseInt(instruction[1]); j <= Integer.parseInt(instruction[4]); j++) {
                    switch (instruction[0]) {
                        case "turnon":
                            grid[i][j] = 1;
                            break;
                        case "toggle":
                            if (grid[i][j] == 0)
                                grid[i][j] = 1;
                            else
                                grid[i][j] = 0;
                            break;
                        case "turnoff":
                            grid[i][j] = 0;
                            break;
                    }
                }
            }
        }
        scanner.close();
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1)
                    countLitLights++;
            }
        }
        return countLitLights;
    }

    private static int getTotalBrightness(String fileName) throws  FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int totalBrightness = 0;
        int[][] grid = new int[1000][1000];
        String stringInstruction;
        String[] instruction;
        while (scanner.hasNextLine()) {
            stringInstruction = scanner.nextLine();
            if (stringInstruction.startsWith("turn")) {
                stringInstruction = stringInstruction.replaceFirst(" ", "");
            }
            instruction = stringInstruction.replace(" ", ",").split(",");
            for (int i = Integer.parseInt(instruction[2]); i <= Integer.parseInt(instruction[5]); i++) {
                for (int j = Integer.parseInt(instruction[1]); j <= Integer.parseInt(instruction[4]); j++) {
                    switch (instruction[0]) {
                        case "turnon":
                            grid[i][j]++;
                            break;
                        case "toggle":
                            grid[i][j] += 2;
                            break;
                        case "turnoff":
                            if (grid[i][j] > 0)
                                grid[i][j]--;
                            break;
                    }
                }
            }
        }
        scanner.close();
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                totalBrightness += ints[j];
            }
        }
        return totalBrightness;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        //Part One
        System.out.println(getCountLitLights(fileName) + " lights are lit");
        //Part Two
        System.out.println("The total brightness of all lights is " + getTotalBrightness(fileName));
    }
}