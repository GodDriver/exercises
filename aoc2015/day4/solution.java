package ru.goddriver.exercises.aoc2015.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class solution {

    private static int getTheLowestPositiveNumber(String puzzleInput, String startsWith)
            throws NoSuchAlgorithmException {
        int answer = 0;
        while (true) {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update((puzzleInput + answer).getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            String md5Hex = sb.toString();
            if (!md5Hex.startsWith(String.valueOf(startsWith)))
                answer++;
            else
                return answer;
        }
    }

    public static void main(String[] args) throws  NoSuchAlgorithmException{
        String puzzleInput = "bgvyzdsv";
        String startsWithPartOne = "00000";
        String startsWithPartTwo = "000000";
        //Part One
        System.out.println("The lowest number it combines with to make an MD5 hash starting with five zeroes is "
                + getTheLowestPositiveNumber(puzzleInput, startsWithPartOne));
        //Part Two
        System.out.println("The lowest number it combines with to make an MD5 hash starting with six zeroes is "
                + getTheLowestPositiveNumber(puzzleInput, startsWithPartTwo));
    }
}