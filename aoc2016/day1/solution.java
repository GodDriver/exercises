package ru.goddriver.exercises.aoc2016.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

import static java.lang.Math.abs;

public class solution {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        String instructions = scanner.nextLine();
        scanner.close();
        String[] array = instructions.split(", ");
        int x = 0, y = 0;
        String previousStep = "";
        LinkedList<String> linkedList = new LinkedList<>();
        for (String instruction : array) {
            if (instruction.startsWith("R")) {
                switch (previousStep) {
                    case "":
                    case "^": {
                        for (int i = x + 1; i <= x + Integer.parseInt(instruction.substring(1)); i++) {
                            linkedList.add("(" + i + ", " + y + ")");
                        }
                        x += Integer.parseInt(instruction.substring(1));
                        previousStep = ">";
                        break;
                    }
                    case ">": {
                        for (int i = y - 1; i >= y - Integer.parseInt(instruction.substring(1)); i--) {
                            linkedList.add("(" + x + ", " + i + ")");
                        }
                        y -= Integer.parseInt(instruction.substring(1));
                        previousStep = "v";
                        break;
                    }
                    case "v": {
                        for (int i = x - 1; i >= x - Integer.parseInt(instruction.substring(1)); i--) {
                            linkedList.add("(" + i + ", " + y + ")");
                        }
                        x -= Integer.parseInt(instruction.substring(1));
                        previousStep = "<";
                        break;
                    }
                    case "<": {
                        for (int i = y + 1; i <= y + Integer.parseInt(instruction.substring(1)); i++) {
                            linkedList.add("(" + x + ", " + i + ")");
                        }
                        y += Integer.parseInt(instruction.substring(1));
                        previousStep = "^";
                        break;
                    }
                }
            }
            else if (instruction.startsWith("L")) {
                switch (previousStep) {
                    case "":
                    case "^": {
                        for (int i = x - 1; i >= x - Integer.parseInt(instruction.substring(1)); i--) {
                            linkedList.add("(" + i + ", " + y + ")");
                        }
                        x -= Integer.parseInt(instruction.substring(1));
                        previousStep = "<";
                        break;
                    }
                    case "<": {
                        for (int i = y - 1; i >= y - Integer.parseInt(instruction.substring(1)); i--) {
                            linkedList.add("(" + x + ", " + i + ")");
                        }
                        y -= Integer.parseInt(instruction.substring(1));
                        previousStep = "v";
                        break;
                    }
                    case "v": {
                        for (int i = x + 1; i <= x + Integer.parseInt(instruction.substring(1)); i++) {
                            linkedList.add("(" + i + ", " + y + ")");
                        }
                        x += Integer.parseInt(instruction.substring(1));
                        previousStep = ">";
                        break;
                    }
                    case ">": {
                        for (int i = y + 1; i <= y + Integer.parseInt(instruction.substring(1)); i++) {
                            linkedList.add("(" + x + ", " + i + ")");
                        }
                        y += Integer.parseInt(instruction.substring(1));
                        previousStep = "^";
                        break;
                    }
                }
            }
        }
        String[] arrayAnswer;
        arrayAnswer = linkedList.get(linkedList.size() - 1).replaceAll("[()]", "").split(", ");
        int countBlocksAway = abs(Integer.parseInt(arrayAnswer[0])) + abs(Integer.parseInt(arrayAnswer[1]));

        int count = 0;
        int firstLocationVisitTwice = 0;
        String[] arrayAnswerTwo;
        for (int j = 0; j < linkedList.size() - 1; j++) {
            for (int k = j + 1; k < linkedList.size(); k++) {
                if (linkedList.get(j).equals(linkedList.get(k)) && count == 0) {
                    arrayAnswerTwo = linkedList.get(j).replaceAll("[()]", "").split(", ");
                    firstLocationVisitTwice = abs(Integer.parseInt(arrayAnswerTwo[0]))
                            + abs(Integer.parseInt(arrayAnswerTwo[1]));
                    count++;
                }
            }
        }

        //Part One
        System.out.println("Easter Bunny HQ is " + countBlocksAway + " blocks away");
        //Part Two
        System.out.println("The first location visited twice is " + firstLocationVisitTwice + " blocks away");
    }
}