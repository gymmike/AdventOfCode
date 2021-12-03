package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Challenge2ModifiedWithLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        try (Scanner scanner = new Scanner(new File("day1Input.txt"))) {
            //read the first three lines
            for (int i = 0; i < 3; i++) {
                if (scanner.hasNextInt()) {
                    list.addLast(scanner.nextInt());
                }
            }
            // read until end of file
            while (scanner.hasNextInt()) {
                list.addLast(scanner.nextInt());
                if (list.getLast() > list.getFirst()) {
                    count++;
                }
                list.removeFirst();
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
