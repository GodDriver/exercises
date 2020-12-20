package ru.goddriver.exercises.aoc2017.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class solution {

    private static int getPartOne(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        int i = 0;
        int value;
        int numberOfSteps = 0;
        do {
            value = arrayList.get(i);
            arrayList.set(i, value + 1);
            numberOfSteps++;
            i = (i + value) % arrayList.size();
        } while (i != 0);
        scanner.close();
        return numberOfSteps;
    }

    private static int getPartTwo(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (scanner.hasNextInt()) {
            arrayList.add(scanner.nextInt());
        }
        int i = 0;
        int value;
        int numberOfSteps = 0;
        do {
            value = arrayList.get(i);
            if (value >= 3)
                arrayList.set(i, value - 1);
            else
                arrayList.set(i, value + 1);
            numberOfSteps++;
            i = (i + value) % arrayList.size();
        } while (i != 0);
        scanner.close();
        return numberOfSteps;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        //Part One
        System.out.println("Part one answer is " + getPartOne(fileName));
        //Part Two
        System.out.println("Part two answer is " + getPartTwo(fileName));
    }
}