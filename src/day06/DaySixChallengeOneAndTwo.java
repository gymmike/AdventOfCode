package day06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class DaySixChallengeOneAndTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day6Input.txt"));
            List<Integer> timerList = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] numberStrArr = line.split(",");
                for (String n :
                        numberStrArr) {
                    timerList.add(Integer.parseInt(n));
                }
            }
            long total = 0;
            HashMap<String, Long> fishMap = getMap();
            fishMap = getPopulatedMap(fishMap, timerList);
            fishMap = model(fishMap, 256);
            for (Long value :
                    fishMap.values()) {
                total += value;
            }
            System.out.println("Fish count is: " + total);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static HashMap<String, Long> model(HashMap<String, Long> fishMap, int days) {
        for (int i = 0; i < days; i++) {
            long day0Fish = fishMap.get("day0Fish");
            fishMap.put("day0Fish", fishMap.get("day1Fish"));
            fishMap.put("day1Fish", fishMap.get("day2Fish"));
            fishMap.put("day2Fish", fishMap.get("day3Fish"));
            fishMap.put("day3Fish", fishMap.get("day4Fish"));
            fishMap.put("day4Fish", fishMap.get("day5Fish"));
            fishMap.put("day5Fish", fishMap.get("day6Fish"));
            fishMap.put("day6Fish", fishMap.get("day7Fish") + day0Fish);
            fishMap.put("day7Fish", fishMap.get("day8Fish"));
            fishMap.put("day8Fish", day0Fish);
        }
        return fishMap;
    }

    public static HashMap<String, Long> getPopulatedMap(HashMap<String, Long> fishMap, List<Integer> fishList) {
        for (int i = 0; i < fishList.size(); i++) {
            switch (fishList.get(i)) {
                case 0:
                    long before0 = fishMap.get("day0Fish");
                    fishMap.put("day0Fish", before0 + 1);
                    break;
                case 1:
                    long before1 = fishMap.get("day1Fish");
                    fishMap.put("day1Fish", before1 + 1);
                    break;
                case 2:
                    long before2 = fishMap.get("day2Fish");
                    fishMap.put("day2Fish", before2 + 1);
                    break;
                case 3:
                    long before3 = fishMap.get("day3Fish");
                    fishMap.put("day3Fish", before3 + 1);
                    break;
                case 4:
                    long before4 = fishMap.get("day4Fish");
                    fishMap.put("day4Fish", before4 + 1);
                    break;
                case 5:
                    long before5 = fishMap.get("day5Fish");
                    fishMap.put("day5Fish", before5 + 1);
                    break;
                case 6:
                    long before6 = fishMap.get("day6Fish");
                    fishMap.put("day6Fish", before6 + 1);
                    break;
                case 7:
                    long before7 = fishMap.get("day7Fish");
                    fishMap.put("day7Fish", before7 + 1);
                    break;
                case 8:
                    long before8 = fishMap.get("day8Fish");
                    fishMap.put("day8Fish", before8 + 1);
                    break;
            }
        }
        return fishMap;
    }

    public static HashMap<String, Long> getMap() {
        HashMap<String, Long> fishMap = new HashMap<>();
        fishMap.put("day8Fish", 0L);
        fishMap.put("day7Fish", 0L);
        fishMap.put("day6Fish", 0L);
        fishMap.put("day5Fish", 0L);
        fishMap.put("day4Fish", 0L);
        fishMap.put("day3Fish", 0L);
        fishMap.put("day2Fish", 0L);
        fishMap.put("day1Fish", 0L);
        fishMap.put("day0Fish", 0L);
        return fishMap;
    }


}

