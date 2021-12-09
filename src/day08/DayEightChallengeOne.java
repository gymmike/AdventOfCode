package day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayEightChallengeOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day8Input.txt"));
            int total=0;
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(" \\| ");
                String[] symbols = line[1].split(" ");
                for (String symbol :
                        symbols) {
                    int length=symbol.toCharArray().length;
                    if(length==2||length==3||length==4||length==7)
                        total++;
                }
            }
            System.out.println(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
