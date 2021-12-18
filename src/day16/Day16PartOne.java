package day16;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day16PartOne {
    private static Map<String, String> digiMap = new HashMap<>();

    static {
        digiMap.put("0", "0000");
        digiMap.put("1", "0001");
        digiMap.put("2", "0010");
        digiMap.put("3", "0011");
        digiMap.put("4", "0100");
        digiMap.put("5", "0101");
        digiMap.put("6", "0110");
        digiMap.put("7", "0111");
        digiMap.put("8", "1000");
        digiMap.put("9", "1001");
        digiMap.put("A", "1010");
        digiMap.put("B", "1011");
        digiMap.put("C", "1100");
        digiMap.put("D", "1101");
        digiMap.put("E", "1110");
        digiMap.put("F", "1111");
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("src/inputFiles/test16.txt"));
            String binaryString = hexToBin(scanner.nextLine());
            System.out.println(binaryString);
            System.out.println(binaryString.length());
            int sum = 0;
            int offset = 0;
            while (offset < binaryString.length() - 24) {
                String versionStr = binaryString.substring(offset, offset + 3);
                if (Integer.parseInt(binaryString.substring(offset + 3, offset + 6), 2) == 4) {
                    sum += Integer.parseInt(versionStr, 2);
                    offset += 24;
                } else {
                    if (Integer.parseInt(binaryString.substring(offset + 6, offset + 7)) == 1) {
                        int nextElevenValue = Integer.parseInt(binaryString.substring(offset + 7, offset + 18), 2);
                        int length = nextElevenValue * 11;//there are this many bits that are contained in the subpacket
                        //now need to dissect the subpacket and get the version number of every sub packet
                        sum += Integer.parseInt(binaryString.substring(offset, offset + 3), 2);
//                        int flag=0;
//                        while(flag<nextElevenValue/11){
//
//                        }
                        offset += 18 + length;
                    } else {
                        int length = Integer.parseInt(binaryString.substring(offset + 7, offset + 22), 2);
                        sum += Integer.parseInt(binaryString.substring(offset, offset + 3), 2);
                        offset += 22 + length;
                    }
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    static String hexToBin(String s) {
        char[] hex = s.toCharArray();
        String binaryString = "";
        for (char h : hex) {
            binaryString += digiMap.get(String.valueOf(h));
        }
        return binaryString;
    }
}
