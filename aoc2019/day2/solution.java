package ru.goddriver.exercises.aoc2019.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class solution {

    private static int getPartOne(int[] inputProgram) {
        int[] program1 = Arrays.copyOf(inputProgram, inputProgram.length);
        program1[1] = 12;
        program1[2] = 2;
        for (int i = 0; i < program1.length; i += 4) {
            if (program1[i] == 99) {
                break;
            }
            else if (program1[i] == 1)
                program1[program1[i + 3]] = program1[program1[i + 1]] + program1[program1[i + 2]];
            else if (program1[i] == 2)
                program1[program1[i + 3]] = program1[program1[i + 1]] * program1[program1[i + 2]];
        }
        return program1[0];
    }

    private static int getPartTwo(int[] inputProgram) {
        int noun = 0, verb = 0;
        for (int n = 0; n < 100; n++) {
            for (int v = 0; v < 100; v++) {
                int[] program2 = Arrays.copyOf(inputProgram, inputProgram.length);
                program2[1] = n;
                program2[2] = v;
                for (int i = 0; i < program2.length; i += 4) {
                    if (program2[i] == 99 && program2[0] == 19690720) {
                        noun = n;
                        verb = v;
                        break;
                    }
                    else if (program2[i] == 1)
                        program2[program2[i + 3]] = program2[program2[i + 1]] + program2[program2[i + 2]];
                    else if (program2[i] == 2)
                        program2[program2[i + 3]] = program2[program2[i + 1]] * program2[program2[i + 2]];
                }
            }
        }
        return 100 * noun + verb;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "input";
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String[] input = reader.readLine().split(",");
        reader.close();
        int[] program = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            program[i] = Integer.parseInt(input[i]);
        }
        //Part One
        System.out.println("Value at position 0 after the program halts is " + getPartOne(program));
        //Part Two
        System.out.println("100 * noun + verb is " + getPartTwo(program));
    }
}