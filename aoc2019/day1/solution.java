package ru.goddriver.exercises.aoc2019.day1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class solution {

    private static  int getFuelOneModule(int massOfModule) {
        return massOfModule / 3 - 2;
    }

    private static int getFuelOneModuleWithAdded(int massOfModule) {
        int fuelOneModuleWithAdded = 0;
        while (massOfModule > 5) {
            massOfModule = massOfModule / 3 - 2;
            fuelOneModuleWithAdded += massOfModule;
        }
        return fuelOneModuleWithAdded;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(fileName)));
        int sumOfTheFuel = 0;
        int sumOfTheFuelWithAdded = 0;
        while (scanner.hasNextInt()) {
            int massOfModule = scanner.nextInt();
            sumOfTheFuel += getFuelOneModule(massOfModule);
            sumOfTheFuelWithAdded += getFuelOneModuleWithAdded(massOfModule);
        }
        scanner.close();

        //Part One
        System.out.println("The sum of the fuel requirements for all of the modules on your spacecraft is "
                + sumOfTheFuel);
        //Part Two
        System.out.println("The sum of the fuel requirements for all of the modules on your spacecraft when also "
                + "taking into account the mass of the added fuel is " + sumOfTheFuelWithAdded);
    }
}