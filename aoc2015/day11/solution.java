package ru.goddriver.exercises.aoc2015.day11;

import java.util.List;
import java.util.stream.Collectors;

public class solution {

    private static boolean isIncreaseThreeLetters(String string) {
        boolean increase = false;
        for (int i = 0; i < string.length() - 2; i++) {
            if ((char) (string.charAt(i) + 1) == string.charAt(i + 1)
            && (char) (string.charAt(i) + 2) == string.charAt(i + 2)) {
                increase = true;
                break;
            }
        }
        return increase;
    }

    private static boolean isNotContain(String string) {
        return !string.contains("i") && !string.contains("o") && !string.contains("l");
    }

    private static boolean isContainPair(String string) {
        boolean containPair = false;
        List<Character> chars = "cdefghijklmnopqrstuvwxy".chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i) == string.charAt(i + 1)
            && chars.contains(string.charAt(i))) {
                containPair = true;
                break;
            }
        }
        return (string.contains("aa") || string.contains("bb") || string.contains("zz")) && containPair;
    }

    private static String nextPassword(String string) {
        StringBuilder nextPassword = new StringBuilder();
        int count = 1;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) == 'z' && count == 1)
                nextPassword.append('a');
            else {
                nextPassword.append((char) (string.charAt(i) + count));
                count = 0;
            }
        }
        return nextPassword.reverse().toString();
    }

    public static void main(String[] args) {
        String password = "hxbxwxba";
        int count = 2;
        while (count != 0) {
            if (isIncreaseThreeLetters(password)
            && isNotContain(password)
            && isContainPair(password)) {
                System.out.println("Next password is " + password);
                count--;
            }
            password = nextPassword(password);
        }
    }
}