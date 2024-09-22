I playerInput() metoden laver I en ny Scanner hver gang metoden kaldes

    Scanner keyboard = new Scanner(System.in);

Det kan give problemer. Enten skal I sørge for at lukke den igen med 

    keyboard.close();

Eller lave global felt variable og genbruge Scanneren. 

---

Pas på med at lave talkoder.

    if(dieNumber == -1) { //Double 1

det er svært huske hvad -1 betyder når man kikker på koden en måned senere. 
Her kunne i returnere int[] og skrive

    if(dieNumbers[0] + dieNumbers[1] == 2) 

i stedet for.

---

Det er rigtigt fint med player() metoden, den er dog blevet lidt lang, så forsøg at bryd den op med et par metodekald.

