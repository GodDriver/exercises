package ru.goddriver.exercises.aoc2018.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class solution {

    private static int getCountRemainUnits(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String polymer = scanner.nextLine();
        scanner.close();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < polymer.length(); i++) {
            linkedList.add(polymer.charAt(i));
        }
        ListIterator<Character> listIterator = linkedList.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.hasPrevious())
                listIterator.previous();
            Character char1 = listIterator.next();
            Character char2 = listIterator.next();
            if ((Character.toUpperCase(char1) == char2 && char1 == Character.toLowerCase(char2))
                    || (char1 == Character.toUpperCase(char2) && (Character.toLowerCase(char1) == char2))) {
                listIterator.remove();
                listIterator.previous();
                listIterator.remove();
            }
        }
        return linkedList.size();
    }

    private static int getTheShortestPolymer(String fileName) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String polymer = scanner.nextLine();
        scanner.close();
        LinkedList<Character> linkedList = new LinkedList<>();
        for (int i = 0; i < polymer.length(); i++) {
            linkedList.add(polymer.charAt(i));
        }
        ArrayList<Integer>  sizeOfPolymers = new ArrayList<>();
        for (char letter = 'a'; letter <= 'z'; letter++) {
            LinkedList<Character> linkedListTmp = new LinkedList<>(linkedList);
            ListIterator<Character> listIterator = linkedListTmp.listIterator();
            while (listIterator.hasNext()) {
                Character character = listIterator.next();
                if (Character.toLowerCase(character) == letter) {
                    listIterator.remove();
                }
            }
            listIterator = linkedListTmp.listIterator();
            while (listIterator.hasNext()) {
                if (listIterator.hasPrevious())
                    listIterator.previous();
                Character char1 = listIterator.next();
                Character char2 = listIterator.next();
                if ((Character.toUpperCase(char1) == char2 && char1 == Character.toLowerCase(char2))
                        || (char1 == Character.toUpperCase(char2) && (Character.toLowerCase(char1) == char2))) {
                    listIterator.remove();
                    listIterator.previous();
                    listIterator.remove();
                }
            }
            sizeOfPolymers.add(linkedListTmp.size());
        }
        int indexMin = sizeOfPolymers.indexOf(Collections.min(sizeOfPolymers));
        return sizeOfPolymers.get(indexMin);
    }

    public static void main(String[] args) throws Exception{
        String fileName = "input";
        //Part One
        System.out.println("Count of remaining units is " + getCountRemainUnits(fileName));
        //Part Two
        System.out.println("The length of the shortest polymer is " + getTheShortestPolymer(fileName));
    }
}