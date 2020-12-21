package ru.goddriver.exercises.aoc2020.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class solution {

    private static int getGroupCounts(String groupAnswers) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < groupAnswers.length(); i++) {
            set.add(groupAnswers.charAt(i));
        }
        return set.size();
    }

    private static int getEveryOneCounts(String groupAnswers, int countPerson) {
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < groupAnswers.length(); i++) {
            if (charCountMap.containsKey(groupAnswers.charAt(i))) {
                charCountMap.put(groupAnswers.charAt(i), charCountMap.get(groupAnswers.charAt(i)) + 1);
            }
            else {
                charCountMap.put(groupAnswers.charAt(i), 1);
            }
        }
        int count = 0;
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == countPerson)
                count++;
        }
        return count;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        StringBuilder group = new StringBuilder();
        int sum = 0, sum2 = 0;
        int countPerson = 0;
        while (scanner.hasNextLine()) {
            String onePerson = scanner.nextLine();
            if (!onePerson.equals("")) {
                group.append(onePerson);
                countPerson++;
            }
            else {
                sum += getGroupCounts(group.toString());
                sum2 += getEveryOneCounts(group.toString(), countPerson);
                group = new StringBuilder();
                countPerson = 0;
            }
            if (!scanner.hasNextLine()) {
                sum += getGroupCounts(group.toString());
                sum2 += getEveryOneCounts(group.toString(), countPerson);
            }
        }
        scanner.close();
        System.out.println("The sum of those counts is " + sum);
        System.out.println("The sum of those counts in part two is " + sum2);
    }
}