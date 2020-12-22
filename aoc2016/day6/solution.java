package ru.goddriver.exercises.aoc2016.day6;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class solution {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        List<String> messages = new ArrayList<>();
        int maxMessageLength = 0;
        while (scanner.hasNextLine()) {
            String message = scanner.nextLine();
            messages.add(message);
            if (maxMessageLength < message.length())
                maxMessageLength = message.length();
        }
        scanner.close();
        StringBuilder errorCorMess = new StringBuilder();
        StringBuilder originalMess = new StringBuilder();
        for (int i = 0; i < maxMessageLength; i++) {
            HashMap<Character, Integer> countChar = new HashMap<>();
            for (String message : messages) {
                Character character = message.charAt(i);
                if (countChar.containsKey(character))
                    countChar.put(character, countChar.get(character) + 1);
                else
                    countChar.put(character, 1);
            }
            int maxValueInCountChar = Collections.max(countChar.values());
            int minValueInCountChat = Collections.min(countChar.values());
            for (Map.Entry<Character, Integer> entry : countChar.entrySet()) {
                if (entry.getValue() == maxValueInCountChar) {
                    errorCorMess.append(entry.getKey());
                }
                if (entry.getValue() == minValueInCountChat) {
                    originalMess.append(entry.getKey());
                }
            }
        }
        System.out.println("The error-corrected version of the message is " + errorCorMess.toString());
        System.out.println("The original message is " + originalMess.toString());
    }
}