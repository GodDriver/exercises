package ru.goddriver.exercises.aoc2017.day4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    private static int getCountValidPass(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int countValidPass = 0;
        String[] array;
        while (scanner.hasNextLine()) {
            HashMap<String, Integer> map = new HashMap<>();
            array = scanner.nextLine().split(" ");
            for (String word : array) {
                map.put(word, 1);
            }
            if (array.length == map.size())
                countValidPass++;
        }
        scanner.close();
        return countValidPass;
    }

    private static int getCountValidPassPartTwo(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int countValidPass = 0;
        String[] array;
        while (scanner.hasNextLine()) {
            HashMap<ArrayList<Character>, Integer> map = new HashMap<>();
            array = scanner.nextLine().split(" ");
            for (String word : array) {
                ArrayList<Character> arrayList = new ArrayList<>();
                for  (int i = 0; i < word.length(); i++) {
                    arrayList.add(word.charAt(i));
                }
                Collections.sort(arrayList);
                map.put(arrayList, 1);
            }
            if (array.length == map.size())
                countValidPass++;
        }
        scanner.close();
        return countValidPass;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        //Part One
        System.out.println(getCountValidPass(fileName) + " passphrases are valid");
        //Part Two
        System.out.println(getCountValidPassPartTwo(fileName) + " passphrases are valid under this new system policy");
    }
}