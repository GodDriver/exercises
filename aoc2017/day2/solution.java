package ru.goddriver.exercises.aoc2017.day2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int checksum = 0;
        int sum = 0;
        while (scanner.hasNextLine()) {
            String[] rowString = scanner.nextLine().replaceAll("\t", " ")
                    .split(" ");
            int size = rowString.length;
            int[] row = new int [size];
            //Part One
            for (int i = 0; i < size; i++) {
                row[i] = Integer.parseInt(rowString[i]);
            }
            Arrays.sort(row);
            checksum += row[size - 1] - row[0];
            // Part Two
            int num1 = 0, num2;
            for (int i = 0; i < size; i++) {
                int count = 0;
                for (int j = 0; j < size; j++) {
                    if (row[i] % row[j] == 0) {
                        count++;
                        if (count == 1) {
                            num1 = row[j];
                        }
                        if (count == 2) {
                            num2 = row[j];
                            sum += row[i] / Math.min(num1, num2);
                        }
                    }
                }
            }
        }
        scanner.close();
        System.out.println("The checksum for the spreadsheet in puzzle input is " + checksum); //Part One
        System.out.println("The sum of each row's result in puzzle input is " + sum); //Part Two
    }
}