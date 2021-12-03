package day02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayTwoChallengeTwo {
    public static void main(String[] args) {
        int depth = 0, aim = 0, horizontal = 0;
        try (Scanner scanner = new Scanner(new File("day2Input.txt"))) {
            // read until end of file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] instruction = line.split(" ");
                String command = instruction[0];
                int data = Integer.parseInt(instruction[1]);
                switch (command) {
                    case "forward":
                        horizontal += data;
                        depth += data * aim;
                        break;
                    case "down":
                        aim += data;
                        break;
                    case "up":
                        aim -= data;
                        break;
                }
            }
            System.out.println(depth * horizontal);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
