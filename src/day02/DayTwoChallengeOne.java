package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwoChallengeOne {
    public static void main(String[] args) {
        int depth = 0, horizontal = 0;
        try (Scanner scanner = new Scanner(new File("src/inputFiles/day2Input.txt"))) {
            // read until end of file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] instruction = line.split(" ");
                String command = instruction[0];
                int data = Integer.parseInt(instruction[1]);
                switch (command) {
                    case "forward":
                        horizontal += data;
                        break;
                    case "down":
                        depth += data;
                        break;
                    case "up":
                        depth -= data;
                        break;
                }
            }
            System.out.println(depth * horizontal);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
