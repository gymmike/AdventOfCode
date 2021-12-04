package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayThreeChallengeOneHardCoded {
    public static void main(String[] args) {
        System.out.println(calculatePowerConsumption() );
    }

    public static int calculatePowerConsumption() {
        Scanner scanner;
        int[] flags = new int[12];
        try {
            scanner = new Scanner(new File("day3Input.txt"));
            String[] arr = new String[1000];
            for (int i = 0; i < 1000; i++) {
                arr[i] = scanner.nextLine();
            }
            for (int k = 0; k < flags.length; k++) {
                int flag = 0;
                for (int i = 0; i < arr.length; i++) {
                        if (arr[i].toCharArray()[k] > 48) {
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
            String epsilonString="";
            for (int flag : flags) {
                gammaString = gammaString + flag;
                epsilonString=epsilonString+(1-flag) ;
            }
            return Integer.parseInt(gammaString, 2)*Integer.parseInt(epsilonString,2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }
}

