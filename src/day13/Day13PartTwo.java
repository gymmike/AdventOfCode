package day13;


   import java.io.File;
   import java.io.FileNotFoundException;
   import java.util.Scanner;

public class Day13PartTwo {
    private static final int[][] grid = new int[1350][1350];

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day13Input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.equals("")) {
                    String[] numbers = line.split(",");
                    grid[Integer.parseInt(numbers[1])][Integer.parseInt(numbers[0])] = 1;
                } else {
                    while (scanner.hasNextLine()) {
                        String[] instruction = scanner.nextLine().split(" ")[2].split("=");
                        int foldingLine = Integer.parseInt(instruction[1]);
                        if (instruction[0].equals("y")) {
                            for (int i = 1349; i > foldingLine; i--) {
                                for (int j = 0; j < 1350; j++) {
                                    if (grid[i][j] == 1) {
                                        grid[foldingLine - Math.abs(foldingLine - i)][j] = 1;
                                        grid[i][j] = 0;
                                    }
                                }
                            }
                        } else {
                            if (instruction[0].equals("x")) {
                                for (int i = 0; i < 1350; i++) {
                                    for (int j = 1349; j > foldingLine; j--) {
                                        if (grid[i][j] == 1) {
                                            grid[i][foldingLine - Math.abs(foldingLine - j)] = 1;
                                            grid[i][j] = 0;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 500; i++) {
                System.out.println();
                for (int j = 0; j < 500; j++) {
                    if(grid[i][j]==1){
                        System.out.print("\u2588");
                    }else{
                        System.out.print(" ");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

