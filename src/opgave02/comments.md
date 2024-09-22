I denne linje

    while(wantsToPlay == true) playCraps();

er wantsToPlay allerede en booelan, så 

    while(wantToPlay)

gør det samme. Og jeg foretrækker tuborg start/slut klammer, selvom det er en oneliner.

---

Lav typerne af

    private static double wins = 0;
    private static double lost = 0;

om til int, så slipper I for at caste i 

    System.out.println("Du vandt " + (int)wins + " gange");
    System.out.println("Du tabte " + (int)lost + " gange");

---
Det er måske lidt overkill med en metode til at lægge to tal sammen.

    private static int diceSum(int dice1, int dice2){
        return (dice1+dice2);
    }

---

Når der kun er to terninger, så synes jeg at 

    twoDice[0] = (int) (Math.random() * 6 + 1);
    twoDice[1] = (int) (Math.random() * 6 + 1);

er mere læsbart end

    for (int i = 0; i < twoDice.length; i++) twoDice[i] = (int) (Math.random() * 6 + 1);

---

    if(answear.equals("ja")) return true;
    else return false;

kan erstattes af

    return answear.equals("ja");

---

IntelliJ fortæller at der er no usages af

    private static int point = 0;

det betyder at den kan fjernes.

---

    private static boolean winOrNot;

bruges kun i playCraps() metoden, så lav en lokal variabel der i stedet for en global.

---

