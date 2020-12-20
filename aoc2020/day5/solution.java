package ru.goddriver.exercises.aoc2020.day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class solution {

    public static int getRow(String seat) {
        int a = 0, b = 127;
        for (int i = 0; i < 7; i++) {
            if (seat.charAt(i) == 'F')
                b = (a + b) / 2;
            else
                a = (a + b + 1) / 2;
        }
        return a;
    }

    public static int getColumn(String seat) {
        int a = 0, b = 7;
        for (int i = 7; i < 10; i++) {
            if (seat.charAt(i) == 'L')
                b = (a + b) / 2;
            else
                a = (a + b + 1) / 2;
        }
        return a;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String seat = scanner.nextLine();
            list.add(getRow(seat) * 8 + getColumn(seat));
        }
        //Part One
        System.out.println("The highest seat ID on a boarding pass is " + Collections.max(list));
        //Part Two
        Collections.sort(list);
        ArrayList<Integer> listFull = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            listFull.add(list.get(0) + i);
        }
        listFull.removeAll(list);
        System.out.println("The ID of my seat is " + listFull.get(0));
    }
}