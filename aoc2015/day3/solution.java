package ru.goddriver.exercises.aoc2015.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    private static int getNumberOfHouses(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String delivers = scanner.nextLine();
        HashMap<String, Integer> houses = new HashMap<>();
        int x = 0, y = 0;
        String locationHouse = "(" + x + ", " + y + ")";
        houses.put(locationHouse, 1);
        for (int i = 0; i < delivers.length(); i++) {
            if (delivers.charAt(i) == '^')
                y++;
            else if (delivers.charAt(i) == 'v')
                y--;
            else if (delivers.charAt(i) == '>')
                x++;
            else if (delivers.charAt(i) == '<')
                x--;
            locationHouse = "(" + x + ", " + y + ")";
            houses.put(locationHouse, 1);
        }
        scanner.close();
        return houses.size();
    }

    private static int getNumberOfHousesNextYear(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String delivers = scanner.nextLine();
        scanner.close();
        HashMap<String, Integer> houses = new HashMap<>();
        int xS = 0, yS = 0; //Santa
        int xR = 0, yR = 0; //Robo-Santa
        String locationHouse = "(" + xS + ", " + yS + ")";
        houses.put(locationHouse, 1);
        for (int i = 0; i < delivers.length(); i++) {
            if (i % 2 == 0) {
                if (delivers.charAt(i) == '^')
                    yS++;
                else if (delivers.charAt(i) == 'v')
                    yS--;
                else if (delivers.charAt(i) == '>')
                    xS++;
                else if (delivers.charAt(i) == '<')
                    xS--;
                locationHouse = "(" + xS + ", " + yS + ")";
            }
            else {
                if (delivers.charAt(i) == '^')
                    yR++;
                else if (delivers.charAt(i) == 'v')
                    yR--;
                else if (delivers.charAt(i) == '>')
                    xR++;
                else if (delivers.charAt(i) == '<')
                    xR--;
                locationHouse = "(" + xR + ", " + yR + ")";
            }
            houses.put(locationHouse, 1);
        }
        return houses.size();
    }

    public static void main(String[] args) throws Exception{
        String fileName = "input";
        //Part One
        System.out.println(getNumberOfHouses(fileName) + " houses receive presents");
        //Part Two
        System.out.println(getNumberOfHousesNextYear(fileName) + " houses receive presents next year");
    }
}