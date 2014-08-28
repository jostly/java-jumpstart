# Aktiv marknad

På en verklig aktiemarknad rör sig priset på aktier hela tiden (eller så länge börsen är öppen åtminstone).

Ett sätt att simulera detta är att ha en fil med aktier och deras priser, exempelvis:

	ERIC B;Ericsson B;80.3
	SKA B;Skandia B;110.7
	TRMO;Transmode;67.8

Då skulle man kunna se till att så fort den filen ändras läses den in i programmet och uppdaterar priserna för motsvarande aktier

I paketet java.nio.file finns bland annat funktioner för att övervaka filer för förändring. Detta finns beskrivet [i denna tutorial](http://docs.oracle.com/javase/tutorial/essential/io/notification.html)

## Uppgiften

* Skapa ett system som kan läsa in och skapa Stock från innehållet i en fil.
* Övervaka filen för att upptäcka när den förändrats
* Vid förändring, läs in och uppdatera priset på aktier
	* Förutsätt att aktier inte försvinner från listan
	* Om en aktie tillkommer, skapa ett nytt Stock-objekt för den; annars uppdatera priset på existerande objekt
	

