package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day14PartTwo {
    private static final HashMap<String, Character> map = new HashMap<>();
    private static HashMap<String, Long> pairs = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/day14Input.txt"));
            String firstLine = scanner.nextLine();
            char firstChar = firstLine.charAt(0);
            char lastChar = firstLine.charAt(firstLine.length() - 1);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] symbols = scanner.nextLine().split(" -> ");
                map.put(symbols[0], symbols[1].toCharArray()[0]);
            }
            int offset = 0;
            while (offset < firstLine.length()-1 ) {
                String pair = firstLine.charAt(offset) + "" + firstLine.charAt(offset + 1);
                pairs.put(pair, pairs.get(pair) == null ? 1L : pairs.get(pair) + 1L);
                offset += 1;
            }
            for (int i = 0; i < 10; i++) {
                HashMap<String, Long> newPairs = new HashMap<>();
                pairs.forEach((k, v) -> addPairCount(k, newPairs));
                pairs = newPairs;
            }
            Map<Character, Long> letterCount = new HashMap<>();
            for (Map.Entry<String, Long> element : pairs.entrySet()) {
                String poly = element.getKey();
                Long amount = element.getValue();

                letterCount.put(poly.charAt(0), letterCount.containsKey(poly.charAt(0)) ? letterCount.get(poly.charAt(0)) + amount : amount);
                letterCount.put(poly.charAt(1), letterCount.containsKey(poly.charAt(1)) ? letterCount.get(poly.charAt(1)) + amount : amount);
            }
            letterCount.put(firstChar, letterCount.get(firstChar) + 1);
            letterCount.put(lastChar, letterCount.get(lastChar) + 1);
            Long min = Collections.min(letterCount.values());
            Long max = Collections.max(letterCount.values());
            long absValue = max - min;
            System.out.println(absValue / 2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addPairCount(String pair, HashMap<String, Long> newPairs) {
        if (!pairs.containsKey(pair)) {
            newPairs.put(pair, pairs.get(pair));
        } else {
            Long times = pairs.get(pair);
            Character value = map.get(pair);
            String pair1 = pair.charAt(0) + "" + value;
            String pair2 = value + "" + pair.charAt(1);
            newPairs.put(pair1, !newPairs.containsKey(pair1) ? times : (newPairs.get(pair1)) + times);
            newPairs.put(pair2, !newPairs.containsKey(pair2) ? times : (newPairs.get(pair2)) + times);
        }
    }
}
