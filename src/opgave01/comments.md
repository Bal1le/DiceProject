Disse 4 linjer

        if(twoDice[0] == twoDice[1]) sameAmountOfEyes++;
        if(heightAmount < twoDice[0]+twoDice[1]) heightAmount = twoDice[0] + twoDice[1];
        amountOfTimesEachDie[twoDice[0]]++;
        amountOfTimesEachDie[twoDice[1]]++;

tænker jeg hører til i `updateStatistics()` metoden, sammen med 

    diceSum += dieOne + dieTwo;

fra sumOfTwoDice metoden.

---
