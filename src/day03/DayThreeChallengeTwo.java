package day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class DayThreeChallengeTwo {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("day3Input.txt"));
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            System.out.println(Integer.parseInt(getOnly(list, 0, 1), 2)*Integer.parseInt(getOnly(list, 0, 0), 2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getOnly(List<String> list, int po, int z) {
        int flag = 0;
        if (po < 12 && list.size() > 1) {
            for (int k = 0; k < list.size(); k++) {
                for (String s : list) {
                    if (s.toCharArray()[po] > 48) {
                        flag++;
                    } else {
                        flag--;
                    }
                }
            }
                if (flag >= 0) {
                    list = list.stream().filter(a -> (Character.getNumericValue(a.charAt(po)) == 1-z)).collect(Collectors.toList());
                } else {
                    list = list.stream().filter(a -> (Character.getNumericValue(a.charAt(po)) == z)).collect(Collectors.toList());
                }
                return getOnly(list, po + 1, z);
        }
        return list.get(0);
    }

}