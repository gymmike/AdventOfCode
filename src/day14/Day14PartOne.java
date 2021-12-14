package day14;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Day14PartOne {
    public static final HashMap<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/test.txt"));
            StringBuilder builder = new StringBuilder();
            builder.append(scanner.nextLine());
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] symbols = scanner.nextLine().split(" -> ");
                map.put(symbols[0], symbols[1]);
            }
            int offset = 0;
            for (int i = 0; i < 10; i++) {
                while (offset != builder.length() - 1) {
//                    StringBuilder keyBuilder=new StringBuilder();
                    String key = builder.charAt(offset) + "" + builder.charAt(offset + 1);
//                    keyBuilder.append(builder.charAt(offset)).append(builder.charAt(offset+1));
//                    builder.insert(offset+1,map.get(keyBuilder.toString()));
                    builder.insert(offset + 1, map.get(key));
                    offset += 2;
                }
                offset=0;
            }
            HashMap<Character, Integer> letterMap = new HashMap<>();
            for (Character c :
                    builder.toString().toCharArray()) {
                if(letterMap.keySet().contains(c)){
                    letterMap.put(c,letterMap.get(c)+1);
                }else{
                    letterMap.put(c,1);
                }
            }
            long max=0;
            long min= (int) letterMap.values().toArray()[0];
            for (Integer value:letterMap.values()
            ) {
                if (value>max)max=value;
                if (value<min)min=value;
            }
            System.out.println("max = "+max+", min = "+min+", the difference is "+(max-min));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
