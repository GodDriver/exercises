package ru.goddriver.exercises.aoc2015.day16;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class solution {

    private static boolean compareMessages(HashMap<String, Integer> detectedMessage) {
        HashMap<String, Integer> message = new HashMap<>() {
            {
                put("children", 3);
                put("cats", 7);
                put("samoyeds", 2);
                put("pomeranians", 3);
                put("akitas", 0);
                put("vizslas", 0);
                put("goldfish", 5);
                put("trees", 3);
                put("cars", 2);
                put("perfumes", 1);
            }
        };
        return message.entrySet().containsAll(detectedMessage.entrySet());
    }

    private static boolean isRealAuntSue(HashMap<String, Integer> detectedMessage) {
        if (detectedMessage.containsKey("children") && detectedMessage.get("children") != 3)
            return false;
        if (detectedMessage.containsKey("cats") && detectedMessage.get("cats") <= 7)
            return false;
        if (detectedMessage.containsKey("samoyeds") && detectedMessage.get("samoyeds") != 2)
            return false;
        if (detectedMessage.containsKey("pomeranians") && detectedMessage.get("pomeranians") >= 3)
            return false;
        if (detectedMessage.containsKey("akitas") && detectedMessage.get("akitas") != 0)
            return false;
        if (detectedMessage.containsKey("vizslas") && detectedMessage.get("vizslas") != 0)
            return false;
        if (detectedMessage.containsKey("goldfish") && detectedMessage.get("goldfish") >= 5)
            return false;
        if (detectedMessage.containsKey("trees") && detectedMessage.get("trees") <= 3)
            return false;
        if (detectedMessage.containsKey("cars") && detectedMessage.get("cars") != 2)
            return false;
        return !detectedMessage.containsKey("perfumes") || detectedMessage.get("perfumes") == 1;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String filename = "input";
        Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)));
        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine()
                    .replaceAll("Sue ", "")
                    .replaceAll(":", ",")
                    .split(", ");
            HashMap<String, Integer> detectedMessage = new HashMap<>();
            for (int i = 1; i < line.length - 1; i += 2) {
                detectedMessage.put(line[i], Integer.parseInt(line[i + 1]));
            }
            if (compareMessages(detectedMessage)) {
                System.out.println("The number of the Sue that got the gift is " + line[0]);
            }
            if (isRealAuntSue(detectedMessage))
                System.out.println("The number of the real Aunt Sue is " + line[0]);
        }
        scanner.close();
    }
}
