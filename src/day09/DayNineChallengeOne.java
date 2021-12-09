package day09;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DayNineChallengeOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day9Input.txt"));
            List<Integer> list = new ArrayList<>();
            int lineLength = getLineLength();
            int[][] matrix = new int[100][lineLength];
            int lineNumber = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int i = 0; i < lineLength; i++) {
                    matrix[lineNumber][i] = Character.getNumericValue(line.charAt(i));
                }
                lineNumber++;
            }
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < lineLength; j++) {
                    int current, up, down, left, right;
                    current = matrix[i][j];
                    if (i > 0) {
                        up = matrix[i - 1][j];
                    } else {
                        up = 10;
                    }
                    if (i < lineNumber - 1) {
                        down = matrix[i + 1][j];
                    } else {
                        down = 10;
                    }
                    if (j > 0) {
                        left = matrix[i][j - 1];
                    } else {
                        left = 10;
                    }
                    if (j < lineLength - 1) {
                        right = matrix[i][j + 1];
                    } else {
                        right = 10;
                    }
                    if (current < up && current < down && current < left && current < right)
                        list.add(current);
                }
            }
            int total = 0;
            for (Integer integer :
                 list){
                total+=integer;
            }
            total+=list.size();
            System.out.println(total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static int getLineLength(){
        int length=0;
        try {
            Scanner scanner=new Scanner(new File("src/inputFiles/day9Input.txt"));
             length=scanner.nextLine().length();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return length;
    }
}
