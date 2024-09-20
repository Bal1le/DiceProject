package opgave02;

import java.util.Scanner;

public class Craps {

    private static int point = 0;
    private static boolean winOrNot;
    private static boolean wantsToPlay = true;
    private static double wins = 0;
    private static double lost = 0;

    public static void main(String[] args) {

        while(wantsToPlay == true) playCraps();

        playStats();

    }

    private static void playCraps(){

        int[] twoDice = twoDice();

        if(twoDice[0]+twoDice[1] == 7 ||twoDice[0]+twoDice[1] == 11){
            System.out.printf("%20s %4d\n", "Du har vandet ved at slå ",diceSum(twoDice[0],twoDice[1]));
            System.out.println();
            wantsToPlay = wantsToPlayMore();
            wins++;
            return;
        }
        if(twoDice[0]+twoDice[1] == 2 || twoDice[0]+twoDice[1] == 3 || twoDice[0]+twoDice[1] == 12){
            System.out.printf("%20s %4d\n", "Du har tabt ved at slå ",diceSum(twoDice[0],twoDice[1]));
            System.out.println();
            wantsToPlay = wantsToPlayMore();
            lost++;
            return;
        }

        System.out.printf("%20s %4d\n", "Du fik totalt point:",diceSum(twoDice[0],twoDice[1]));
        System.out.println();

        winOrNot = roolForPoint(diceSum(twoDice[0],twoDice[1]));

        if(winOrNot == true){
            System.out.printf("%20s %4d\n","Du vandt ved at rulle",diceSum(twoDice[0],twoDice[1]));
            wantsToPlay = wantsToPlayMore();
            wins++;
        }
        else {
            System.out.printf("%20s\n", "Du tabete ved at rulle 7");
            wantsToPlay = wantsToPlayMore();
            lost++;
        }
    }

    private static int[] twoDice(){

        int[] twoDice = new int[2];

        for (int i = 0; i < twoDice.length; i++) twoDice[i] = (int) (Math.random() * 6 + 1);

        System.out.printf("%20s %4d %d\n","Du har rullet: ",twoDice[0],twoDice[1]);

        return twoDice;
    }

    private static int diceSum(int dice1, int dice2){
        return (dice1+dice2);
    }

    private static boolean roolForPoint(int point){
        while(true) {
            int[] twoDice = twoDice();

            if (diceSum(twoDice[0], twoDice[1]) == 7) return false;
            else if (diceSum(twoDice[0],twoDice[1]) == point) return true;

            System.out.printf("%20s %4d\n", "Totalt",diceSum(twoDice[0],twoDice[1]));
            System.out.println();

        }
    }

    private static boolean wantsToPlayMore(){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Vil du spille et spil mere? ");

        String answear = keyboard.nextLine();

        if(answear.equals("ja")) return true;

        else return false;
    }

    private static void playStats(){

        System.out.println();
        System.out.println("Du vandt " + (int)wins + " gange");
        System.out.println("Du tabte " + (int)lost + " gange");
        System.out.println("Du har i gennemsnittet vundet " + (wins/(wins+lost))*100 + "% af tiden");
        System.out.println();

    }
}