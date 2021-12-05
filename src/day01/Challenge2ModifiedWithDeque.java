package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Challenge2ModifiedWithDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;
        try (Scanner scanner = new Scanner(new File("src/inputFiles/day1Input.txt"))) {
            //read the first three lines
            for (int i = 0; i < 3; i++) {
                if (scanner.hasNextInt()) {
                    deque.addLast(scanner.nextInt());
                }
            }
            // read until end of file
            while (scanner.hasNextInt()) {
                deque.addLast(scanner.nextInt());
                if (deque.getLast() > deque.getFirst()) {
                    count++;
                }
                deque.removeFirst();
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
