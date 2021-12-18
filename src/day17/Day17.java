package day17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day17 {
    private static int count = 0;
    private static int xTargetLeft = 0;
    private static int xTargetRight = 0;
    private static int yTargetTop = 0;
    private static int yTargetBottom = 0;
    private static int xMax = 0;
    private static int xMin = 0;
    private static int yMin = 0;

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day17Input.txt"));
            String coordinate = scanner.nextLine().split(":")[1];
            String[] c = coordinate.split(",");
            String xRange = c[0].split("=")[1];
            xTargetLeft = Integer.parseInt(xRange.split("\\.\\.")[0]);
            xTargetRight = Integer.parseInt(xRange.split("\\.\\.")[1]);
            String yRange = c[1].split("=")[1];
            yTargetTop = Integer.parseInt(yRange.split("\\.\\.")[1]);
            yTargetBottom = Integer.parseInt(yRange.split("\\.\\.")[0]);
            xMax = xTargetRight;
            yMin = yTargetBottom;
            int yMax = Math.abs(yTargetBottom) - 1;
            int sum = 0;
            while (sum < xTargetLeft) {
                xMin++;
                sum += xMin;
            }
            for (int i = xMin; i <= xMax; i++) {
                for (int j = yMin; j <= yMax; j++) {
                    checkIfInTarget(i, j, i - 1, j - 1);
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void checkIfInTarget(int x, int y, int originalX, int originalY) {
        if (y <= yTargetTop && y >= yTargetBottom && x <= xTargetRight && x >= xTargetLeft) {
            count++;
            return;
        }
        if (x > xMax || x < xMin || y < yMin) {
            return;
        }
        checkIfInTarget(originalX > 0 ? (x + originalX) : x, y + originalY, originalX - 1, originalY - 1);
    }
}
