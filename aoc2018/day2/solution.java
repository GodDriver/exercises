package ru.goddriver.exercises.aoc2018.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    private static int getChecksum(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int twoTimes = 0;
        int threeTimes = 0;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            HashMap<Integer, Integer> counter = new HashMap<>();
            for (char letter = 'a'; letter <= 'z'; letter++) {
                int letterCount = 0;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == letter) {
                        letterCount++;
                    }
                }
                if (letterCount > 0)
                    counter.put(letterCount, 1);
            }
            if (counter.containsKey(2))
                twoTimes++;
            if (counter.containsKey(3))
                threeTimes++;
        }
        scanner.close();
        return twoTimes * threeTimes;
    }

    private static String getCommonLetters(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        while (true) {
            for (int i = 0; i < lines.size(); i++) {
                String a = lines.get(i);
                for (int j = i + 1; j < lines.size(); j++) {
                    String b = lines.get(j);
                    int diff = 0;
                    int k = 0;
                    StringBuilder letters = new StringBuilder();
                    while (diff <= 1 && k < a.length()) {
                        if (a.charAt(k) != b.charAt(k))
                            diff++;
                        else
                            letters.append(a.charAt(k));
                        k++;
                    }
                    if (diff == 1) {
                        scanner.close();
                        return letters.toString();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "input";
        //Part One
        System.out.println("The checksum for list of box IDs is " + getChecksum(fileName));
        //Part Two
        System.out.println("Common letters between the two correct box IDs are "
                + getCommonLetters(fileName));
    }
}