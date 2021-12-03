package day01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Challenge2ModifiedWithLinkedList {
    public static void main(String[] args) {
        Scanner scanner = null;
        LinkedList<Integer> list = new LinkedList<>();
        int count = 0;
        try {
            scanner = new Scanner(new File("day1input.txt"));
            //read the first three lines
            for (int i = 0; i < 3; i++) {
                if (scanner.hasNextInt()) {
                    list.addLast(scanner.nextInt());
                }
            }
            // read until end of file (EOF)
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
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
