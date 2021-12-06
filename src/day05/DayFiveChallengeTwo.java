package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFiveChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/test.txt"));
            int[][] matrix = new int[10][10];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(" -> ");
                //over here populate the parallel array with actual data.
                //the goal if to make every element that are on the line increase by one
                //so we have to determine the line, we only want horizontal lines or vertical lines
                //it's either x1=x2 or y1=y2, if it does not satisfy either condition, then the line
                //is discarded
                //so the condition is either x1-x2=0 or y1-y2=0, in the case of x1=x2, y-1 will be the
                //index where the parallel array increase by one, from point x1 to point x2
                //how to store the points? using a tree? key and value? will the data benefit from sorting?
                //or do you not store the data at all? just do anther split and do the calculation directly
                int x1, x2, y1, y2;
                String[] fArr = arr[0].split(",");
                String[] sArr = arr[1].split(",");
                x1 = Integer.parseInt(fArr[0]);
                x2 = Integer.parseInt(sArr[0]);
                y1 = Integer.parseInt(fArr[1]);
                y2 = Integer.parseInt(sArr[1]);
                if (x1 == x2 && y1 == y2) {
                    matrix[x1][y1]++;
                } else if (x1 == x2) {
                    int diff = y1 - y2;
                    int diffAb = Math.abs(diff);
                    matrix[x1][y1]++;
                    for (int i = 1; i <= diffAb; i++) {
                        matrix[x1][y1 - diff / diffAb*i]++;
                    }
                } else if (y1 == y2) {
                   int diff=x1-x2;
                   int diffAb=Math.abs(diff);
                   matrix[x1][y1]++;
                    for (int i =1; i <= diffAb; i++) {
                        matrix[x1-diff/diffAb*i][y1]++;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if (matrix[i][j] > 1) {
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
