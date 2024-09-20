package opgave03;

import java.util.Scanner;

public class Pigs {
    private static int[] playerPoints = new int[2];
    private static int wantsToPlayTo = 0;
    private static double numberOfThrows = 0;
    private static double numberOfTurns = 0;

    public static void main(String[] args) {

        gameMaster();

    }

    private static void gameMaster(){
        boolean isItPlayerOne = true;

        wantsToPlayTo = playTo();


        while(playerPoints[0] < wantsToPlayTo && playerPoints[1] < wantsToPlayTo){

            if(isItPlayerOne == true){

                System.out.println("------------------------------------------------------");
                System.out.println();
                System.out.println("Det er spiller 1's tur");

                player(playerPoints[0],1);
                isItPlayerOne = false;
            }
            else {

                System.out.println("------------------------------------------------------");
                System.out.println();
                System.out.println("Det er spiller 2's tur");

                player(playerPoints[1],2);
                isItPlayerOne = true;
            }
        }

        finishGame(playerPoints[0],playerPoints[1]);

        gameStats();

    }

    private static void player(int points, int player){

        boolean wantToThrowDie = true;
        int playerPoint = points;
        int dieNumber = 0;

        while(wantToThrowDie == true){

            dieNumber = throwTwoDie();

            if(dieNumber == -1){

                System.out.println();
                System.out.println("Du har slået to 1'er, du har dermed mistede din tur og alle dine point");

                playerPoints[player-1] = 0;

                System.out.println("Du har hermed " + playerPoints[player - 1] + ".");
                System.out.println();

            }

            if(dieNumber == 1) {

                System.out.println();
                System.out.println("Du har slået en 1'er, du har dermed mistede din tur");
                System.out.println("Du har hermed stadig " + playerPoints[player - 1]+".");
                System.out.println();

                playerPoint = 0;

                numberOfTurns++;
                return;
            }

            playerPoint += dieNumber;

            if(playerPoint >= wantsToPlayTo){

                playerPoints[player - 1] = playerPoint;

                System.out.println();
                System.out.println("Du har nu " + playerPoints[player - 1] + ".");
                System.out.println();

                numberOfTurns++;
                return;
            }

            wantToThrowDie = playerInput();

            if(wantToThrowDie == false) {

                playerPoints[player - 1] = playerPoint;

                System.out.println();
                System.out.println("Du har nu " + playerPoints[player - 1] + ".");
                System.out.println();

                playerPoint = 0;

                numberOfTurns++;
                return;
            }

            System.out.println();

        }
    }

    private static int throwTwoDie(){

        int[] twoDice = new int[2];

        for (int i = 0; i < twoDice.length; i++) twoDice[i] = (int) (Math.random()*6+1);

        System.out.println("Du har slået: " + twoDice[0] + " " + twoDice[1]);

        numberOfThrows += 2;

        if(twoDice[0] == 1 && twoDice[1] == 1) return -1;

        if(twoDice[0] == 1 || twoDice[1] == 1) return 1;

        return (twoDice[0] + twoDice[1]);
    }

    private static boolean playerInput(){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Vil du forsætte med at spille: ");

        String answear = keyboard.nextLine();

        if(answear.equals("ja")) return true;

        else return false;
    }

    private static void finishGame(int pointSpiller1, int pointSpiller2){

        int vinderSpiller = 0;
        int vinderPoint = 0;

        int taberSpiller = 0;
        int taberPoint = 0;

        if(pointSpiller1 >= wantsToPlayTo) {
            vinderSpiller = 1;
            vinderPoint = pointSpiller1;
            taberSpiller = 2;
            taberPoint = pointSpiller2;
        }

        else{
            vinderSpiller = 2;
            vinderPoint = pointSpiller2;

            taberSpiller = 1;
            taberPoint = pointSpiller1;
        }

        System.out.println("Spiller " + vinderSpiller + " har fundet Spillet!!");
        System.out.println("Spilleren fik " + vinderPoint);

        System.out.println("Spiller " + taberSpiller + " fik " + taberPoint);

    }

    private static int playTo(){

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hvad vil du spille til: ");

        int answear = keyboard.nextInt();

        return answear;
    }

    private static void gameStats(){

        System.out.println("------------------------------------------------");
        System.out.println();

        System.out.println("Der er blevet kastet: " + numberOfThrows);
        System.out.println("Der har været: " + numberOfTurns + " tur");
        System.out.println("Der har i gennemsnittet blevet kastet: " + (numberOfThrows/numberOfTurns) + " pr. tur");

    }
}