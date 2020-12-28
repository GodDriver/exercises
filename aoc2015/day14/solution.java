package ru.goddriver.exercises.aoc2015.day14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class solution {

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        int time = 2503;
        HashMap<String, Integer> speeds = new HashMap<>();
        HashMap<String, Integer> timeFlies = new HashMap<>();
        HashMap<String, Integer> timeRests = new HashMap<>();
        HashMap<String, Integer> distances = new HashMap<>();
        HashMap<String, Integer> points = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(" ");
            String name = line[0];
            int speed = Integer.parseInt(line[3]);
            speeds.put(name, speed);
            int timeFly = Integer.parseInt(line[6]);
            timeFlies.put(name, timeFly);
            int timeRest = Integer.parseInt(line[13]);
            timeRests.put(name, timeRest);
            distances.put(name, 0);
            points.put(name, 0);
        }
        scanner.close();
        for (int afterTime = 1; afterTime <= time; afterTime++) {
            for (Map.Entry<String, Integer> entry : distances.entrySet()) {
                String name = entry.getKey();
                int speed = speeds.get(name);
                int timeFly = timeFlies.get(name);
                int timeRest = timeRests.get(name);
                int remainder = Math.min(afterTime % (timeFly + timeRest), timeFly);
                distances.put(name, (afterTime / (timeFly + timeRest) * timeFly + remainder) * speed);
            }
            int maxDistance = Collections.max(distances.values());
            for (Map.Entry<String, Integer> entry : distances.entrySet()) {
                if (entry.getValue() == maxDistance)
                    points.put(entry.getKey(), points.get(entry.getKey()) + 1);
            }
        }
        System.out.println("The winning reindeer has traveled " + Collections.max(distances.values()) + " km");
        System.out.println("The winning reindeer has " + Collections.max(points.values()) + " points");
    }
}