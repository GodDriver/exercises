package ru.goddriver.exercises.aoc2016.day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class solution {

    private static String getHash(String puzzleInput, int index)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((puzzleInput + index).getBytes());
        byte[] digest = md.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        return sb.toString();
    }

    private static String getPasswordPartOne(String puzzleInput, String startsWith)
            throws NoSuchAlgorithmException {
        int index = 0;
        StringBuilder output = new StringBuilder();
        while (true) {
            String md5Hex = getHash(puzzleInput, index);
            if (md5Hex.startsWith(String.valueOf(startsWith)))
                output.append(md5Hex.charAt(5));
            index++;
            if (output.length() == 8)
                return output.toString();
        }
    }

    private static String getPasswordPartTwo(String puzzleInput, String startsWith)
            throws NoSuchAlgorithmException {
        int index = 0;
        HashMap<Integer, String> map = new HashMap<>();
        do {
            String md5Hex = getHash(puzzleInput, index);
            if (md5Hex.startsWith(String.valueOf(startsWith)) && Character.isDigit(md5Hex.charAt(5))) {
                int i = Integer.parseInt(String.valueOf(md5Hex.charAt(5)));
                if (i < 8 && !map.containsKey(i))
                    map.put(i, String.valueOf(md5Hex.charAt(6)));
            }
            index++;
        } while (map.size() != 8);
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            output.append(map.get(i));
        }
        return output.toString();
    }

    public static void main(String[] args) throws  NoSuchAlgorithmException{
        String puzzleInput = "cxdnnyjw";
        String startsWith = "00000";
        //Part One
        System.out.println("The password in Part One is " + getPasswordPartOne(puzzleInput, startsWith));
        //Part Two
        System.out.println("The password in Part Two is " + getPasswordPartTwo(puzzleInput, startsWith));
    }
}