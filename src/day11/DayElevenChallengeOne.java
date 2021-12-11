package day11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class DayElevenChallengeOne {
    private static final int[][] grid = new int[10][10];

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/test.txt"));
            int total = 0;
            while (scanner.hasNextLine()) {
                for (int i = 0; i < 10; i++) {
                    grid[i] = Arrays.stream(scanner.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
                }
            }
            for (int k = 0; k < 100; k++) {
                HashSet<String> flashedCoordinates = new HashSet<>();
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        checkIfFlash(i, j, flashedCoordinates);
                    }
                }
                total += flashedCoordinates.size();
            }
            System.out.println(total);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void checkIfFlash(int x, int y, HashSet<String> flashed) {
        if (flashed.contains(x + " " + y)) return;
        grid[x][y] = grid[x][y] + 1;
        //if the coordinate has not flashed in this step
        if (grid[x][y] % 10 == 0) {
            flashed.add(x + " " + y);
            if (x > 0) {
                checkIfFlash(x - 1, y, flashed);
            }
            if (y > 0) {
                checkIfFlash(x, y - 1, flashed);
            }
            if (x < 9) {
                checkIfFlash(x + 1, y, flashed);
            }
            if (y < 9) {
                checkIfFlash(x, y + 1, flashed);
            }
            if (x > 0 && y > 0) {
                checkIfFlash(x - 1, y - 1, flashed);
            }
            if (x > 0 && y < 9) {
                checkIfFlash(x - 1, y + 1, flashed);
            }
            if (x < 9 && y < 9) {
                checkIfFlash(x + 1, y + 1, flashed);
            }
            if (x < 9 && y > 0) {
                checkIfFlash(x + 1, y - 1, flashed);
            }
        }
    }
}
