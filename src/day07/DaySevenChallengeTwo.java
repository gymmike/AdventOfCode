package day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySevenChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day7Input.txt"));
            int[] array = null;
            while (scanner.hasNextLine()) {
                String[] numberStr = scanner.nextLine().split(",");
                array = new int[numberStr.length];
                for (int i = 0; i < numberStr.length; i++) {
                    array[i] = Integer.parseInt(numberStr[i]);
                }
            }
            int totalFuel = 0;
            double average = Arrays.stream(array).average().orElse(Double.NaN);
//            int ave = (int) Math.ceil(average);//96864332
//            int ave = (int) Math.round(average);96864332
            int ave = (int) Math.floor(average);//96864235
            for (int i = 0; i < array.length; i++) {
                int stepsNeeded = Math.abs(array[i] - ave);
                int fuelForThisCrab = 0;
                if (stepsNeeded % 2 ==0) {
                    fuelForThisCrab = (stepsNeeded + 1) * (stepsNeeded / 2);
                } else {
                    fuelForThisCrab = (stepsNeeded + 1) * (stepsNeeded / 2) + (stepsNeeded + 1) / 2;
                }
                totalFuel += fuelForThisCrab;
            }
            System.out.println("Total fuel consumed = " + totalFuel);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
