package day04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayFourChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day4Input.txt"));
            Queue<Integer> queue = getBingoNumbers(scanner);
            Map<int[][], Boolean> map = new HashMap<>();
            getBoards(scanner, map);
            drawFirstFour(queue, map);
            getLastBingoBoard(queue, map);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void getLastBingoBoard(Queue<Integer> queue, Map<int[][], Boolean> map) {
        //get the value of the boards that haven't had a bingo, it has to be bigger than 0
        int iterableSize = 0;
        for (boolean value : map.values()) {
            if (value) iterableSize++;
        }
        int next;
        while (iterableSize > 0 && !queue.isEmpty()) {
            next = queue.poll();
            for (int[][] board : map.keySet()) {
                if (map.get(board)) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            //if the board has got that number, first mark that number as -1, then see if there is bingo
                            if (board[i][j] == next) {
                                board[i][j] = -1;
                                //determine if this board has got bingo
                                boolean rowFlag = true;
                                //see if the row has got a bingo
                                for (int k = 0; k < 5; k++) {
                                    if (board[i][k] != -1) {
                                        rowFlag = false;
                                        break;
                                    }
                                }
                                boolean columnFlag = true;
                                //if the row didn't have a bingo already, now check if the column has a bingo
                                if (!rowFlag) {
                                    for (int k = 0; k < 5; k++) {
                                        if (board[k][j] != -1) {
                                            columnFlag = false;
                                            break;
                                        }
                                        //can't just use one flag and do the flip here, in that case only one number
                                        //needs to be -1 in that column to turn flag into true
                                    }
                                    //can't just use one flag and do the flip here， in that case, it will always be set to true
                                }

                                //if there is a bingo, that board should be set to false
                                if (rowFlag || columnFlag) {
                                    map.put(board, false);
                                    int sum = 0;
                                    for (int l = 0; l < 5; l++) {
                                        for (int m = 0; m < 5; m++) {
                                            if (board[l][m] != -1) {
                                                sum += board[l][m];
                                            }
                                        }
                                    }
                                    System.out.println("sum=" + sum + "; next=" + next);
                                    System.out.println("score = " + sum * next);
                                    iterableSize--;
                                }
                            }
                        }
                    }
                }
            }
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

    public static void getBoards(Scanner scanner, Map<int[][], Boolean> map) {
        while (scanner.hasNextLine()) {
            int[][] board = new int[5][5];
            scanner.nextLine();
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = scanner.nextInt();
                }
            }
            map.put(board, true);
        }
    }

    public static void drawFirstFour(Queue<Integer> queue, Map<int[][], Boolean> map) {
        //first time draw four numbers
        for (int i = 0; i < 4; i++) {
            Integer chosen = queue.poll();
            for (int[][] board : map.keySet()) {
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (board[j][k] == chosen) {
                            board[j][k] = -1;
                        }
                    }
                }
            }
        }
    }
}
