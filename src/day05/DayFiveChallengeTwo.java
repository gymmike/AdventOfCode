package day05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DayFiveChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day5Input.txt"));
            int[][] matrix = new int[1000][1000];
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] arr = line.split(" -> ");
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
                        matrix[x1][y1 - diff / diffAb * i]++;
                    }
                } else if (y1 == y2) {
                    int diff = x1 - x2;
                    int diffAb = Math.abs(diff);
                    matrix[x1][y1]++;
                    for (int i = 1; i <= diffAb; i++) {
                        matrix[x1 - diff / diffAb * i][y1]++;
                    }
                } else if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
                    int xDiff = x1-x2;
                    int yDiff = y1-y2;
                    int abYDiff = Math.abs(yDiff);
                    int abXDiff = Math.abs(xDiff);
                    matrix[x1][y1]++;
                    for (int i = 1; i <= abXDiff; i++) {
                        matrix[x1 - xDiff / abXDiff * i][y1 - yDiff / abYDiff * i]++;
                    }

                }
            }
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 1000; j++) {
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
