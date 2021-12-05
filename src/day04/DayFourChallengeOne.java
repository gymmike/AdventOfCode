package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayFourChallengeOne {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day4Input.txt"));
            Queue<Integer> queue = getBingoNumbers(scanner);
            List<int[][]> list = new ArrayList<>();
            getBoards(scanner, list);
            drawFirstFour(queue, list);
            int temp = 0;
            int sum = 0;
            //poll one at a time
            while (!queue.isEmpty()) {
                int next = queue.poll();
                for (int[][] board :
                        list) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            if (board[i][j] == next) {
                                temp = board[i][j];
                                board[i][j] = -1;
                                //determine if this board has got bingo
                                boolean flag = true;
                                for (int k = 0; k < 5; k++) {
                                    if (board[i][k] != -1) {
                                        flag = false;
                                        break;
                                    }
                                }
                                if (!flag) {
                                    for (int k = 0; k < 5; k++) {
                                        if (board[k][j] != -1) {
                                            flag = false;
                                            break;
                                        }
                                    }
                                }
                                if (flag) {
                                    System.out.println("Bingo: " + temp);
                                    System.out.println(temp);
                                    for (int l = 0; l < 5; l++) {
                                        for (int m = 0; m < 5; m++) {
                                            if (board[l][m] != -1) {
                                                sum += board[l][m];
                                            }
                                        }
                                    }
                                    System.out.println("sum=" + sum);
                                    System.out.println("score = " + sum * temp);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Queue<Integer> getBingoNumbers(Scanner scanner) {
        Queue<Integer> queue = new LinkedList<>();
        if (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] numberStrArr = line.split(",");
            for (String n :
                    numberStrArr) {
                queue.add(Integer.parseInt(n));
            }
        }
        return queue;
    }

    public static void getBoards(Scanner scanner, List<int[][]> list) {
        while (scanner.hasNextLine()) {
            int[][] board = new int[5][5];
            scanner.nextLine();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            list.add(board);
        }
    }

    public static void drawFirstFour(Queue<Integer> queue, List<int[][]> list) {
        //first time draw four numbers
        for (int i = 0; i < 4; i++) {
            Integer chosen = queue.poll();
            for (int[][] array :
                    list) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (array[j][k] == chosen) {
                            array[j][k] = -1;
                        }
                    }
                }
            }
        }
    }

}

