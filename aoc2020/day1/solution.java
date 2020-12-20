package ru.goddriver.exercises.aoc2020.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class solution {

    private static int getPartOne(ArrayList<Integer> arrayList) {
        while (true) {
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(0) + arrayList.get(i) == 2020) {
                    return arrayList.get(0) * arrayList.get(i);
                }
                if (i == arrayList.size() - 1) {
                    arrayList.remove(0);
                }
            }
        }
    }

    private static int getPartTwo(ArrayList<Integer> arrayList) {
        while (true) {
            for (int i = 1; i < arrayList.size() - 1; i++) {
                for (int j = i + 1; j < arrayList.size(); j++) {
                    if (arrayList.get(0) + arrayList.get(i) + arrayList.get(j) == 2020) {
                        return arrayList.get(0) * arrayList.get(i) * arrayList.get(j);
                    }
                    if (i == arrayList.size() - 2 && j == arrayList.size() - 1) {
                        arrayList.remove(0);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }
        scanner.close();
        System.out.println("Puzzle answer in Part One " + getPartOne(list));
        System.out.println("Puzzle answer in Part Two " + getPartTwo(list));
    }
}