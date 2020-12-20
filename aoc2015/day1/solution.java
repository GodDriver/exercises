package ru.goddriver.exercises.aoc2015.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static int getFloor(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String instruction = scanner.nextLine();
        int floor = 0;
        for (int i = 0; i < instruction.length(); i++) {
            if (instruction.charAt(i) == '(')
                floor++;
            if (instruction.charAt(i) == ')')
                floor--;
        }
        scanner.close();
        return floor;
    }

    private static int getFirstEnterTheBasement(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String instruction = scanner.nextLine();
        int floor = 0;
        while (true) {
            for (int i = 0; i < instruction.length(); i++) {
                if (instruction.charAt(i) == '(')
                    floor++;
                if (instruction.charAt(i) == ')')
                    floor--;
                if (floor == -1) {
                    scanner.close();
                    return i + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        String fileName = "input";
        //Part One
        System.out.println("Floor at the Santa's instruction is " + getFloor(fileName));
        //Part Two
        System.out.println("First enter the basement on position " + getFirstEnterTheBasement(fileName));
    }
}