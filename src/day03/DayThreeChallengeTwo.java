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
            System.out.println(getOnly(list, 0));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getOnly(List<String> list, int po) {
        int flag = 0;
        if (po < 12 && list.size() > 1) {
            for (int k = 0; k < list.size(); k++) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).toCharArray()[po] > 48) {
                        flag++;
                    } else {
                        flag--;
                    }
                }
            }
            if (flag >= 0) {
                list = list.stream().filter(a -> (a.charAt(po) == 48)).collect(Collectors.toList());
            }  else {
                list = list.stream().filter(a -> (a.charAt(po) == 49)).collect(Collectors.toList());
            }
            return getOnly(list, po + 1);
        }
        return list;
    }

}