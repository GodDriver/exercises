package ru.goddriver.exercises.aoc2019.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class solution {

    private static HashMap<String, Integer> getLocations(String[] wire) {
        int x = 0, y = 0;
        int steps = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : wire) {
            if (s.startsWith("R")) {
                for (int j = 0; j < Integer.parseInt(s.substring(1)); j++) {
                    map.put(("(" + (x + j) + "," + y + ")"), steps++);
                }
                x += Integer.parseInt(s.substring(1));
            } else if (s.startsWith("D")) {
                for (int j = 0; j < Integer.parseInt(s.substring(1)); j++) {
                    map.put(("(" + x + "," + (y - j) + ")"), steps++);
                }
                y -= Integer.parseInt(s.substring(1));
            } else if (s.startsWith("L")) {
                for (int j = 0; j < Integer.parseInt(s.substring(1)); j++) {
                    map.put(("(" + (x - j) + "," + y + ")"), steps++);
                }
                x -= Integer.parseInt(s.substring(1));
            } else if (s.startsWith("U")) {
                for (int j = 0; j < Integer.parseInt(s.substring(1)); j++) {
                    map.put(("(" + x + "," + (y + j) + ")"), steps++);
                }
                y += Integer.parseInt(s.substring(1));
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "input";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String[] wire1 = reader.readLine().split(",");
        String[] wire2 = reader.readLine().split(",");
        reader.close();
        HashMap<String, Integer> map1 = getLocations(wire1);
        HashMap<String, Integer> map2 = getLocations(wire2);
        HashMap<String, Integer> map3 = new HashMap<>();
        for (Map.Entry<String, Integer> pair : map1.entrySet()) {
            if (map2.containsKey(pair.getKey()))
                map3.put(pair.getKey(), pair.getValue());
        }
        int ManhDist = Integer.MAX_VALUE;
        int theFewestCombinedSteps = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> pair : map3.entrySet()) {
            String key = pair.getKey();
            int dist = Math.abs(Integer.parseInt(key.substring(1, key.indexOf(","))))
                    + Math.abs(Integer.parseInt(key.substring(key.indexOf(",") + 1, key.length() - 1)));
            if (dist > 0 && dist < ManhDist) {
                ManhDist = dist;
            }
            int steps = map1.get(key) + map2.get(key);
            if (dist > 0 && steps < theFewestCombinedSteps)
                theFewestCombinedSteps = steps;
        }
        System.out.println("The Manhattan distance from the central port to the closest intersection is " + ManhDist);
        System.out.println("The fewest combined steps the wires must take to reach an intersection is "
                + theFewestCombinedSteps);
    }
}