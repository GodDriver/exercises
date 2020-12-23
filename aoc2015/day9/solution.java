package ru.goddriver.exercises.aoc2015.day9;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class solution {

    private static LinkedList<String> getPermutation(Collection<Integer> codes) {
        Integer[] numbers = codes.toArray(new Integer[0]);
        LinkedList<String> permutations = new LinkedList<>();
        helper(0, numbers, permutations);
        return permutations;
    }

    private static void helper(int start, Integer[] numbers, LinkedList<String> permutations) {
        if (start == numbers.length - 1){
            StringBuilder number = new StringBuilder();
            for(int num: numbers){
                number.append(num);
            }
            permutations.add(number.toString());
            return;
        }

        for (int i = start; i < numbers.length; i++){
            swap(numbers, i, start);
            helper(start + 1, numbers, permutations);
            swap(numbers, i, start);
        }
    }

    private static void swap(Integer[] numbers, int i, int j) {
        int tmp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmp;
    }

    private static HashMap<String, Integer> getPossibleRoutes(List<String> permutations, int[][] distances) {
        HashMap<String, Integer> possibleRoutes = new HashMap<>();
        for (String permutation : permutations) {
            int routeDistance = 0;
            for (int i = 0; i < permutation.length() - 1; i++) {
                routeDistance += distances
                        [Integer.parseInt(String.valueOf(permutation.charAt(i)))]
                        [Integer.parseInt(String.valueOf(permutation.charAt(i + 1)))];
            }
            possibleRoutes.put(permutation, routeDistance);
        }
        return possibleRoutes;
    }

    private static String getRoute(int distance, HashMap<String, Integer> routes) {
        String route = "";
        for (Map.Entry<String, Integer> entry : routes.entrySet()) {
            if (entry.getValue() == distance) {
                route = entry.getKey();
            }
        }
        return route;
    }

    private static void getAnswer(String name, String route, int distance, HashMap<String, Integer> locationToNumber) {
        System.out.print("The " + name + " of these is ");
        for (int i = 0; i < route.length(); i++) {
            for (Map.Entry<String, Integer> entry : locationToNumber.entrySet()) {
                if (entry.getValue() == Integer.parseInt(String.valueOf(route.charAt(i)))) {
                    System.out.print(entry.getKey());
                    if (i != route.length() - 1)
                        System.out.print(" -> ");
                }
            }
        }
        System.out.println(", and so the answer is " + distance);
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        HashMap<String, Integer> locationToCode = new HashMap<>();
        int[][] distances = new int[10][10];
        int code = 0;
        while (scanner.hasNextLine()) {
            String[] array = scanner.nextLine()
                    .replaceAll(" to ", ",")
                    .replaceAll(" = ", ",")
                    .split(",");
            if (!locationToCode.containsKey(array[0]))
                locationToCode.put(array[0], ++code);
            if (!locationToCode.containsKey(array[1]))
                locationToCode.put(array[1], ++code);
            distances[locationToCode.get(array[0])][locationToCode.get(array[1])] = Integer.parseInt(array[2]);
            distances[locationToCode.get(array[1])][locationToCode.get(array[0])] = Integer.parseInt(array[2]);
        }
        scanner.close();
        LinkedList<String> permutations = getPermutation(locationToCode.values());
        HashMap<String, Integer> possibleRoutes = getPossibleRoutes(permutations, distances);
        int shortestDistance = Collections.min(possibleRoutes.values());
        int longestDistance = Collections.max(possibleRoutes.values());
        String shortestRoute = getRoute(shortestDistance, possibleRoutes);
        String longestRoute = getRoute(longestDistance, possibleRoutes);
        getAnswer("shortest", shortestRoute, shortestDistance, locationToCode);
        getAnswer("longest", longestRoute, longestDistance, locationToCode);
    }
}