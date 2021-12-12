package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DayTwelvePartTwo {

    private static final ArrayList<ArrayList<String>> paths = new ArrayList<>();
    private static final HashMap<String, ArrayList<String>> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day12Input.txt"));
            while (scanner.hasNextLine()) {
                String[] caves = scanner.nextLine().split("-");
                if (!map.containsKey(caves[0])) {
                    ArrayList<String> nextCaves = new ArrayList<>();
                    nextCaves.add(caves[1]);
                    map.put(caves[0], nextCaves);
                } else {
                    map.get(caves[0]).add(caves[1]);
                }
                if (!map.containsKey(caves[1])) {
                    ArrayList<String> nextCaves = new ArrayList<>();
                    if (!caves[0].equals("start")) {
                        nextCaves.add(caves[0]);
                    }
                    map.put(caves[1], nextCaves);
                } else {
                    map.get(caves[1]).add(caves[0]);
                }
            }

            for (String cave : map.keySet()) {
                if (cave.equals("start")) {
                    ArrayList<String> currentPath = new ArrayList<>();
                    currentPath.add("start");
                    findNextCave(cave, currentPath);
                }
            }
//            for (ArrayList<String> p : paths
//            ) {
//                System.out.println(p);
//            }
            System.out.println(paths.size());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void findNextCave(String currentCave, ArrayList<String> currentPath) {
        ArrayList<String> nextCaves = map.get(currentCave);
        if (nextCaves != null) {
            for (String nextCave :
                    nextCaves) {
                if (nextCave.equals("end")) {
//                    currentPath.add(nextCave);
                    paths.add(currentPath);
                    continue;
                }
                if (nextCave.charAt(0) >= 97 && nextCave.charAt(0) <= 122) {
                    ArrayList<String> temp = new ArrayList<>();
                    for (String cave :
                            currentPath) {
                        if (cave.charAt(0) >= 97 && cave.charAt(0) <= 122) {
                            temp.add(cave);
                        }
                    }
                    if (((temp.stream().distinct().count() != temp.size()) && currentPath.contains(nextCave)) || nextCave.equals("start") ) {
                        continue;
                    }
                }
                ArrayList<String> newPathList = new ArrayList<>(currentPath);
                newPathList.add(nextCave);
                findNextCave(nextCave, newPathList);
            }
        }
    }
}

