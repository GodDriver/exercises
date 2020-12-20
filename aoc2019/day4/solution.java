package ru.goddriver.exercises.aoc2019.day4;

public class solution {

    public static void main(String[] args) {
        int start = 172851;
        int finish = 675869;
        int countDiffPassPart1 = 0, countDiffPassPart2 = 0;
        for (int i = start; i <= finish; i++) {
            String pass = String.valueOf(i);
            boolean isTwoDigitsTheSame = false;
            boolean isNeverDecrease = true;
            boolean isMeetsDouble = false;
            for (int j = 0; j < pass.length() - 1; j++) {
                if (pass.charAt(j) == pass.charAt(j + 1))
                    isTwoDigitsTheSame = true;
                if (pass.charAt(j) > pass.charAt(j + 1))
                    isNeverDecrease = false;

            }
            for (char num = '0'; num <= '9'; num++) {
                int count = 0;
                for (int j = 0; j < pass.length(); j++) {
                    if (num == pass.charAt(j))
                        count++;
                }
                if (count == 2)
                    isMeetsDouble = true;
            }
            if (isTwoDigitsTheSame && isNeverDecrease) {
                countDiffPassPart1++;
                if (isMeetsDouble)
                    countDiffPassPart2++;
            }
        }
        System.out.println("Different passwords are " + countDiffPassPart1);
        System.out.println("Different passwords in Part Two are " + countDiffPassPart2);
    }
}