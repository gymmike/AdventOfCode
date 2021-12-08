package day07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DaySevenChallengeOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day7Input.txt"));
            List<Integer> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String[] numberStr = scanner.nextLine().split(",");
                for (int i = 0; i < numberStr.length; i++) {
                    list.add(Integer.parseInt(numberStr[i]));
                }
            }
            int totalSteps = 0;
            Collections.sort(list);
            for (int i = 0; i < list.size(); i++) {
                totalSteps+=Math.abs(list.get(i)- list.get(list.size()>>1));
            }
            System.out.println(totalSteps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
