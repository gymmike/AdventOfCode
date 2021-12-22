package day21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day21PartOne {
    public static void main(String[] args) {
        try {
            Scanner scanner=new Scanner(new File("src/inputFiles/day21Input.txt"));
            int player1Pos=Integer.parseInt(scanner.nextLine().split(": ")[1]);
            int player2Pos=Integer.parseInt(scanner.nextLine().split(": ")[1]);
            int player1Val=0,player2Val=0, diceRolls=1;
            boolean shouldContinue=true;
            while(shouldContinue){
                if(diceRolls%6<=3){
                    player1Pos=(player1Pos+diceRolls*3+3)%10;
                    player1Val+=player1Pos==0?10:player1Pos;
                }else{
                    player2Pos=(player2Pos+diceRolls*3+3)%10;
                    player2Val+=player2Pos==0?10:player2Pos;
                }
                if(player1Val>=1000||player2Val>=1000){
                    shouldContinue=false;
                }
                diceRolls+=3;
            }
            System.out.println((diceRolls-1)*(Math.min(player1Val, player2Val)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
