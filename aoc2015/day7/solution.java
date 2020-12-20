package ru.goddriver.exercises.aoc2015.day7;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    private static int getValue(HashMap<String, Integer> map, String wire) {
        int value = Integer.MIN_VALUE;
        try {
            value = Integer.parseInt(wire);
        }
        catch (NumberFormatException e) {
            if (map.containsKey(wire)) {
                value = map.get(wire);
            }
        }
        return value;
    }

    private static int getSignalWire(String fileName, String wire, String overrideWire, int newSignal)
            throws FileNotFoundException, NumberFormatException {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        HashMap<String, Integer> map = new HashMap<>();
        while (!map.containsKey(wire)) {
            if (!scanner.hasNextLine())
                scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
            String line = scanner.nextLine();
            String[] instruction = line.split(" ");
            int length = instruction.length;
            if (overrideWire != null && newSignal != 0)
                map.put(overrideWire, newSignal);
            if (length == 3 && !map.containsKey(instruction[2])
                    && getValue(map, instruction[0]) != Integer.MIN_VALUE)
                map.put(instruction[2], getValue(map, instruction[0]));
            else if (length == 4 && !map.containsKey(instruction[3])
                    && getValue(map, instruction[1]) != Integer.MIN_VALUE) {
                map.put(instruction[3], ~getValue(map, instruction[1]) & 0xffff);
            }
            else if (length == 5 && !map.containsKey(instruction[4])
                    && getValue(map, instruction[0]) != Integer.MIN_VALUE
                    && getValue(map, instruction[2]) != Integer.MIN_VALUE) {
                switch (instruction[1]) {
                    case "LSHIFT" -> map.put(instruction[4],
                            (getValue(map, instruction[0]) << getValue(map, instruction[2])) & 0xffff);
                    case "RSHIFT" -> map.put(instruction[4],
                            (getValue(map, instruction[0]) >> getValue(map, instruction[2])) & 0xffff);
                    case "AND" -> map.put(instruction[4],
                            getValue(map, instruction[0]) & getValue(map, instruction[2]));
                    case "OR" -> map.put(instruction[4],
                            getValue(map, instruction[0]) | getValue(map, instruction[2]));
                }
            }
        }
        scanner.close();
        return map.get(wire);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        //Part One
        String wire = "a";
        System.out.println("The signal ultimately provided to wire " + wire + " is "
                + getSignalWire(fileName, wire, null, 0));
        //Part Two
        String overrideWire = "b";
        int newSignal = getSignalWire(fileName, wire, null, 0);
        System.out.println("New signal ultimately provided to wire " + wire + " is "
                + getSignalWire(fileName, wire, overrideWire, newSignal));
    }
}