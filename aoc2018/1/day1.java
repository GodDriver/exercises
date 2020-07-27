package ru.goddriver.aoc2018;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) throws  Exception {
        String fileName = "input";
        //Part One
        getResultingFrequency(fileName);
        //Part Two
        getFirstFrequencyReachesTwice(fileName);
    }
    public static void getResultingFrequency(String fileName) throws Exception{
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int resFreq = 0;
        while (scanner.hasNextInt()) {
            resFreq += scanner.nextInt();
        }
        scanner.close();
        System.out.println("The resulting frequency is " + resFreq);
    }
    public static void getFirstFrequencyReachesTwice(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int freq = 0;
        HashMap<Integer, Integer> freqs = new HashMap<Integer, Integer>();
        while (true) {
            if (!(scanner.hasNextInt()))
                scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            freq += scanner.nextInt();
            if (freqs.containsKey(freq)) {
                scanner.close();
                System.out.println("The first frequency my device reaches twice is " + freq);
                break;
            }
            else
                freqs.put(freq, 1);
        }
    }
}

