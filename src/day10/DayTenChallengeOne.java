package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class DayTenChallengeOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day10Input.txt"));
            int illegalPoints = 0;
            while (scanner.hasNextLine()) {
                LinkedList<Character> expectedClosing = new LinkedList<>();
                String line = scanner.nextLine();
                char[] row = line.toCharArray();
                outer:
                for (char bracket :
                        row) {
                    switch (bracket) {
                        case '(':
                            expectedClosing.add(')');
                            break;
                        case '[':
                            expectedClosing.add(']');
                            break;
                        case '{':
                            expectedClosing.add('}');
                            break;
                        case '<':
                            expectedClosing.add('>');
                            break;
                        case ')':
                            if (expectedClosing.getLast() == bracket) {
                                expectedClosing.removeLast();
                            } else {
                                illegalPoints += 3;
                                break outer;
                            }
                            break;
                        case ']':
                            if (expectedClosing.getLast() == bracket) {
                                expectedClosing.removeLast();
                            } else {
                                illegalPoints += 57;
                                break outer;
                            }
                            break;
                        case '}':
                            if (expectedClosing.getLast() == bracket) {
                                expectedClosing.removeLast();
                            } else {
                                illegalPoints += 1197;
                                break outer;
                            }
                            break;
                        case '>':
                            if (expectedClosing.getLast() == bracket) {
                                expectedClosing.removeLast();
                            } else {
                                illegalPoints += 25137;
                                break outer;
                            }
                            break;
                    }
                }
            }
            System.out.println("Score = " + illegalPoints);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
