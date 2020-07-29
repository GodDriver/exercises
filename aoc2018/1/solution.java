package ru.goddriver.aoc2018.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) throws  Exception {
        String fileName = "/home/vadik/Documents/IdeaProjects/exercises/src/ru/goddriver/aoc2018/day1/input";
        //Part One
        System.out.println("The resulting frequency is " + getResultingFrequency(fileName));
        //Part Two
        System.out.println("The first frequency reached twice is " + getFirstFrequencyReachesTwice(fileName));
    }

    public static int getResultingFrequency(String fileName) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int resFreq = 0;
        while (scanner.hasNextInt()) {
            resFreq += scanner.nextInt();
        }
        scanner.close();
        return resFreq;
    }

    public static int getFirstFrequencyReachesTwice(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int freq = 0;
        HashMap<Integer, Integer> freqs = new HashMap<>();
        while (true) {
            if (!(scanner.hasNextInt()))
                scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            freq += scanner.nextInt();
            if (freqs.containsKey(freq)) {
                scanner.close();
                return freq;
            }
            else
                freqs.put(freq, 1);
        }
    }
}