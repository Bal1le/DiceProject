package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int diceSum = 0;
    private static int sameAmountOfEyes = 0;
    private static int heightAmount = 0;
    private static int[] amountOfTimesEachDie =  new int [7];

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger.");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller en terning, så længde man lyster.");
        System.out.println("=====================================================");
    }

    private static void playTwoDice(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul to terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] face = rollTwoDice();
            System.out.println("Du rullede: " + face[0] + " " + face[1]);
            sumOfTwoDice(face[0],face[1]);
            System.out.println();

            updateStatistics();

            System.out.print("Rul to terninger? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();

    }

    private static int[] rollTwoDice() {

        int[] twoDice = new int [2];

        for (int i = 0; i < twoDice.length; i++) twoDice[i] = (int) (Math.random() * 6 + 1);

        if(twoDice[0] == twoDice[1]) sameAmountOfEyes++;
        if(heightAmount < twoDice[0]+twoDice[1]) heightAmount = twoDice[0] + twoDice[1];
        amountOfTimesEachDie[twoDice[0]]++;
        amountOfTimesEachDie[twoDice[1]]++;

        return twoDice;
    }

    private static void updateStatistics() {
        rollCount += 2;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");

        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum:", diceSum);
        System.out.printf("%17s %4d\n", "Total samme rul:", sameAmountOfEyes);
        System.out.printf("%17s %4d\n", "Højst rul:", heightAmount);

        System.out.println();
        System.out.print("     Total antal af hver: ");
        System.out.println();

        for(int i = 1;i <= amountOfTimesEachDie.length-1;i++) {
            System.out.print("           ");
            System.out.print(i + "'ere: " + amountOfTimesEachDie[i]);
            System.out.println();
        }
    }

    private static void sumOfTwoDice(int dieOne, int dieTwo){

        diceSum += dieOne + dieTwo;
    }
}