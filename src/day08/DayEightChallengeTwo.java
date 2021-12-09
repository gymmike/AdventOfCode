package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayEightChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day8Input.txt"));
            int total = 0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" \\| ");
                String[] symbols = line[0].split(" ");
                String one = "", four = "";
                for (String symbol :
                        symbols) {
                    int length = symbol.length();
                    if (length == 2) {
                        one = symbol;
                    } else if (length == 4) {
                        four = symbol;
                    }
                }
                String[] outputs = line[1].split(" ");
                char[] output = new char[4];
                for (int i = 0; i < outputs.length; i++) {
                    output[i] = convertToNumber(outputs[i], one, four);
                }
                String value = String.valueOf(output);
//                System.out.println(value);
                total += Integer.parseInt(value);
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static char convertToNumber(String s, String one, String four) {
        int length = s.length();
        char[] foursChar = four.toCharArray();
        char[] fourCorner = {'h', 'h'};
        for (int i = 0; i < foursChar.length; i++) {
            if (foursChar[i] != one.charAt(0) && foursChar[i] != one.charAt(1)) {
                if (fourCorner[0] == 'h') {
                    fourCorner[0] = foursChar[i];
                } else if (fourCorner[1] == 'h') {
                    fourCorner[1] = foursChar[i];
                }
            }
        }
        if (length == 2) {
            return '1';
        } else if (length == 3) {
            return '7';
        } else if (length == 4) {
            return '4';
        } else if (length == 7) {
            return '8';
        } else if (length == 5) {
            if (s.indexOf(one.charAt(0)) != -1 && s.indexOf(one.charAt(1)) != -1) {
                return '3';
            } else if (s.indexOf(fourCorner[0]) != -1 && s.indexOf(fourCorner[1]) != -1) {
                return '5';
            } else {
                return '2';
            }
        } else if (length == 6) {
            if (s.indexOf(four.charAt(0)) != -1 && s.indexOf(four.charAt(1)) != -1 && s.indexOf(four.charAt(2)) != -1 && s.indexOf(four.charAt(3)) != -1) {
                return '9';
            } else if (s.indexOf(fourCorner[0]) != -1 && s.indexOf(fourCorner[1]) != -1) {
                return '6';
            } else {
                return '0';
            }
        }
        return 'k';
    }

}
