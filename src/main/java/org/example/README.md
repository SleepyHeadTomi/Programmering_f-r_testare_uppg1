## Testfall

**Test 1**:
I detta test kontrolleras metoden "calculateBirthYear". Om en giltig ålder matas in av användaren så ska rätt 
ålder beräknas och returneras av metoden. Det kontrolleras genom att använda metoden "assertEquals" som 
jämför det faktiska resultatet med det förväntade resultatet och om de är resultaten är detsamma så passerar 
programmet testet.

    Ålder: 40
    Förväntat resultat: 1983

**Test 2-5**:
Dessa tester kontrollerar metoden "getGreeting". Beroende på om användaren matar in korrekta värden, inkorrekta
värden eller en mix av korrekta och inkorrekta värden, så ska metoden skriva ut en lämplig fras till konsolen.
Det kontrolleras på samma sätt som med Test 1, alltså genom att använda metoden "assertEquals".

Fall med korrekta  värden:
    
    Namn: "Tim"
    Ålder: "21"
    Förväntat resultat: "Hello Tim! You were born in 2002."

Fall med inkorrekta värden:

    Namn: "40"
    Ålder: ""
    Förväntat resultat: "Invalid name and age."

Fall med inkorrekt formatterade värden men med justeringar i metoden:

    Namn: " Tim "
    Ålder: " 21 "
    Förväntat resultat: "Hello Tim! You were born in 2002."

Fall med korrekt namn men felaktig ålder:

    Namn: "Tim"
    Ålder: "!#"
    Förväntat resultat: "Invalid age. Must be an integer."

Fall med inkorrekt namn men rätt ålder:

    Namn: ""
    Ålder: "40"
    Förväntat resultat: "Invalid name. Must contain at least one letter."

**Test 6**:
Denna metod, "isValidNumber", ska returnera true om användarens inmatade ålder
är korrekt och false om inmatningen är inkorrekt. Det kontrolleras genom att använda metoden "assertTrue" och 
metoden "assertFalse". Genom att skicka in argument som jag vet är korrekta respektive inkorrekta kan jag testa
att metoden beter sig som den ska. 

Test med giltiga gränsvärden (Här används "assertTrue" för att kontrollera det faktiska resultat):

    Ålder: "6"
    Förväntat resultat: true

    Ålder: "100"
    Förväntat resultat: true

Test med ogiltiga gränsvärden (Här används "assertFalse"):

    Ålder: "5"
    Förväntat resultat: false

    Ålder: "101"
    Förväntat resultat: false

Sedan kontrolleras att metoden hanterar icke-numeriska värden på ett korrekt sätt och till det så används 
"assertFalse".

Test med ogiltiga argument:

    Ålder: "4t"
    Förväntat resultat: false

    Ålder: "#!"
    Förväntat resultat: false

    Ålder: ""
    Förväntat resultat: false

**Test 7**:
Metoden "isValidName" testas på samma sätt som föregående metod, "isValidNumber", allså med hjälp av metoderna
"assertTrue" och "assertFalse" tillsammans med korrekta och inkorrekta argument. Det ända kravet för att argument
ska vara godkänt är att det innehåller minst ett alfabetiskt tecken.

Test med giltiga argument:

    Namn: "£T@11"
    Förväntat resultat: true

    Name: "Ö"
    Förväntat resultat: true

Test med ogiltiga argument:
    
    Namn: "40"
    Förväntat resultat: false

    Namn: ""
    Förväntat resultat: false

### Djupare förklaring

**Test 1**:
Denna metod, "calculateBirthYear" är den som anropas sist i programmet. Så om programmet har kommit hit då vet
vi att alla argument är korrekta och det enda som vi ska kontrollera är att rätt födelseår beräknas och
returneras av metoden. Och det är exakt det som vi kontorllerar i detta test.

**Test 2-5**:
"getGreeting"-metoden har ju till uppgift att skriva ut ett meddelande till konsolen och baserat på vilka
argument som är korrekta eller inte korrekta kommer meddelandet att se annorlunda ut. Med andra ord, så är det
detta som måste testas, att rätt meddelande skrivs ut i konsolen. Så det är fyra scenarios som vi måste test,
det första är om båda argumenten från användaren är korrekta, det andra är om namnet är korrekt men åldern är
inkorrekt, det tredje är om åldern är korrekt men namnet är inkorrekt och det sista är om båda argumenten är
inkorrekta. Och som kan ses ovan så är det just det som testas. Dessutom testas att argumenten "trimmas" innan
de förs vidare och detta för att kontrollera att programmet inte kraschar om användaren råkar komma 
"space"-knappen på tangentbordet. Att trimma argumenten kom jag på senare och jag valde att placera
trim-metoden i början av "getGreeting" eftersom det gjorde att jag inte behövde ändra så mycket i koden.

**Test 6-7**:    
Jag testar gränsvärden, både inom och untanför intervallet, bara för att säkerställa att villkoren är korrekta.
Jag testar felaktiga karaktärer, tom sträng, mellanslag. Både metoderna "isValidName" och "isValidAge" har
returntypen boolean. Så i mina unittester använder jag metoderna "assertTrue" respektive "assertFalse" för att
kontrollera om metoderna ger tillbaka rätt returntyp.

Jag är inte så strikt i vad jag låter passera i metoden "isValidName", så länge strängen innehåller minst en bokstav så 
returneras true. Sen kan strängen bestå av vilket annat tecken som helst. Så i "assertTrue" sker ett metodanrop på 
"isValidName" och i denna skickar jag in argument som ska ge tillbaka villkoret true och tvärtom för "assertFalse".
Jag testar att metoden returnerar true med ett strängargument som består av minst en bokstav och om det består av
bokstäver som finns i det svenska alfabetet. Eftersom "assertTrue" säkerställer att villkoret som returnerats 
är true så vet jag att min metod hittills fungerar som den ska. Sen måste jag testa att felaktig inmatningar
ger tillbaka false. Då anväder jag metoden "assertFalse" och skickar in argument som bör ge false.
Argumenten som jag skickar in är strängar utan bokstäver och tomma. Eftersom "assertFalse"
kontrollerar att villkoret som skickas tillbaka är false så vet jag nu att min metod fungerar som den ska.

Vad det gäller "isValidAge" så ska den enbart ge tillbaka true om strängen består av heltal mellan 6-100
(100 inkluderat). Så jag testar gränsvärdena, de inom intervallet ska ge tillbaka true och då används "assertTrue"
och de untanför ska ge tillbaka false och då används "assertFalse". Sen testar jag att strängar utan siffror, eller
med en mix av olika karaktärer, ger tillbaka false och avslutningsvis testas så att inga tomma strängar eller mellanslag.
Dessa tester visar att det bara är strängar beståendes av siffror returnerar true och allting annat
ger tillbaka false och det är precis det jag vill.