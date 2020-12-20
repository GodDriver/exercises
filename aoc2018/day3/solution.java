package ru.goddriver.exercises.aoc2018.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Objects;
import java.util.Scanner;

public class solution {

    private static String[][] getTwoDimArray(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String[][] fabricSquare = new String[1000][1000];
        String[] claimParse;
        while (scanner.hasNextLine()) {
            claimParse = scanner.nextLine().replaceAll("[ #]", "")
                    .replaceAll("[,@:x]", " ")
                    .split(" ");
            for (int i = Integer.parseInt(claimParse[2]);
                 i < Integer.parseInt(claimParse[2]) + Integer.parseInt(claimParse[4]); i++) {
                for (int j = Integer.parseInt(claimParse[1]);
                     j < Integer.parseInt(claimParse[1]) + Integer.parseInt(claimParse[3]); j++) {
                    if (fabricSquare[i][j] == null)
                        fabricSquare[i][j] = claimParse[0];
                    else
                        fabricSquare[i][j] = "X";
                }
            }
        }
        scanner.close();
        return fabricSquare;
    }

    private static int getSquareInches(String fileName) throws Exception {
        String[][] fabricSquare = getTwoDimArray(fileName);
        int squareInches = 0;
        for (String[] strings : fabricSquare) {
            for (int j = 0; j < fabricSquare[0].length; j++) {
                if (Objects.equals(strings[j], "X"))
                    squareInches++;
            }
        }
        return squareInches;
    }

    private static int getClaimID(String fileName) throws Exception {
        String[][] fabricSquare = getTwoDimArray(fileName);
        String[] claimParse;
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        while (true) {
            int claimID = 0;
            claimParse = scanner.nextLine().replaceAll("[ #]", "")
                    .replaceAll("[,@:x]", " ")
                    .split(" ");
            for (int i = Integer.parseInt(claimParse[2]);
                 i < Integer.parseInt(claimParse[2]) + Integer.parseInt(claimParse[4]); i++) {
                for (int j = Integer.parseInt(claimParse[1]);
                     j < Integer.parseInt(claimParse[1]) + Integer.parseInt(claimParse[3]); j++) {
                    if (fabricSquare[i][j].equals(claimParse[0]))
                        claimID++;
                    if (claimID == Integer.parseInt(claimParse[3]) * Integer.parseInt(claimParse[4])) {
                        scanner.close();
                        return Integer.parseInt(claimParse[0]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "input";
        //Part One
        System.out.println(getSquareInches(fileName)
                + " square inches of fabric are within two or more claims");
        //Part Two
        System.out.println("The ID of the only claim that doesn't overlap is "
                + getClaimID(fileName));
    }
}