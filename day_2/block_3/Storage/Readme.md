# Lagring

Det är rätt onödigt att behöva ha backup av ens aktieportfölj på papper för att fylla i den varje gång man startar programmet. Det vore mycket bättre om man kunde spara innehavet på disk och läsa upp det vid uppstart.

Paketet java.io innehåller klasser för att skriva och läsa textfiler; spara portföljen på lämpligt format (tips: XML är **inte** lämpligt format)

## Uppgiften

* Spara portföljen i en fil när programmet avslutas
* Ladda portföljen från fil - om filen existerar - när programmet startas
* Felhantering:
	* Vad händer om filen är trasig när man försöker läsa den?
	* Vad händer om programmet kraschar medan den skriver filen, går det att göra det felsäkert så att vi inte får förstörd data av det?

