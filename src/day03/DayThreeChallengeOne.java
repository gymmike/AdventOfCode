package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DayThreeChallengeOne {
    public static void main(String[] args) {
        System.out.println(calculatePowerConsumption());
    }

    public static int calculatePowerConsumption() {
        int[] flags = new int[12];
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day3Input.txt"));
            LinkedList<String> list = new LinkedList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            for (int k = 0; k < flags.length; k++) {
                int flag = 0;
                for (String s : list) {
                    if (s.toCharArray()[k] > 48) {
                        flag++;
                    } else {
                        flag--;
                    }
                }
                if (flag > 0) {
                    flags[k] = 1;
                } else {
                    flags[k] = 0;
                }
            }
            String gammaString = "";
            String epsilonString = "";
            for (int flag : flags) {
                gammaString = gammaString + flag;
                epsilonString = epsilonString + (1 - flag);
            }
            return Integer.parseInt(gammaString, 2) * Integer.parseInt(epsilonString, 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
