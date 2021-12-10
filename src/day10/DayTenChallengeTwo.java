package day10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DayTenChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day10Input.txt"));
            ArrayList<LinkedList<Character>> expectedClosingListLists = new ArrayList<>();
            while (scanner.hasNextLine()) {
                LinkedList<Character> expectedClosing = new LinkedList<>();
                expectedClosingListLists.add(expectedClosing);
                char[] line = scanner.nextLine().toCharArray();
                ArrayList<Character> row = new ArrayList<>();
                for (int i = 0; i < line.length; i++) {
                    row.add(line[i]);
                }
                outer:
                for (char bracket :
                        row) {
                    switch (bracket) {
                        case '(':
                            expectedClosing.add(')');
                            break;
                        case '[':
                            expectedClosing.add(']');
                            break;
                        case '{':
                            expectedClosing.add('}');
                            break;
                        case '<':
                            expectedClosing.add('>');
                            break;
                        case ')':
                        case '>':
                        case ']':
                        case '}':
                            if (expectedClosing.getLast() == bracket) {
                                expectedClosing.removeLast();
                            } else {
                                expectedClosingListLists.remove(expectedClosing);
                                break outer;
                            }
                            break;
                    }
                }
            }
            ArrayList<Long> scoreList = new ArrayList<>();
            for (LinkedList<Character> list : expectedClosingListLists
            ) {
                scoreList.add(getScore(list));
            }
            Collections.sort(scoreList);
            System.out.println(scoreList.get(scoreList.size() / 2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static long getScore(LinkedList<Character> list) {
        long listScore = 0L;
        for (int i = list.size() - 1; i >= 0; i--) {
            switch (list.get(i)) {
                case (')'):
                    listScore = listScore * 5 + 1;
                    break;
                case (']'):
                    listScore = listScore * 5 + 2;
                    break;
                case ('}'):
                    listScore = listScore * 5 + 3;
                    break;
                case ('>'):
                    listScore = listScore * 5 + 4;
                    break;
            }
        }
        return listScore;
    }
}
