package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountThreeMeasurementSliding {
    public static void main(String[] args) {
        //in this case, I need four numbers to compare, I will compare the the sum of one to 3, then 2 to 4
        //updated, just the first one with the fourth will be enough
        int previous = 0, previous1 = 0, previous2 = 0, next;
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/inputFiles/day1Input.txt"))) {
            //read the first three lines
            if (scanner.hasNextInt()) {
                previous = scanner.nextInt();
            }
            if (scanner.hasNextInt()) {
                previous1 = scanner.nextInt();
            }
            if (scanner.hasNextInt()) {
                previous2 = scanner.nextInt();
            }
            // read until end of file
            while (scanner.hasNextInt()) {
                next = scanner.nextInt();
                if (next > previous) {
                    count++;
                }
                previous = previous1;
                previous1 = previous2;
                previous2 = next;
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
