package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CountNumberOfIncreases {
    public static void main(String[] args) {
        Scanner scanner = null;
        int previous = 0, next = 0;
        int count = 0;
        try {
            scanner = new Scanner(new File("C:/Users/Aguang/Desktop/AdventOfCode/day1input.txt"));
            //read the first line
            if (scanner.hasNextInt()) {
                previous = scanner.nextInt();
            }
            // read until end of file (EOF)
            while (scanner.hasNextInt()) {
                next = scanner.nextInt();
                if (next > previous) {
                    count++;
                }
                previous = next;
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
