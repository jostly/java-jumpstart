# Exceptionhantering

Om ett oväntat fall uppstår kommer java avbryta det normala programflödet och istället "kasta ett Exception" (throw Exception). Det har man troligtvis stött på i form av NullPointerException.

För att kunna hantera dessa felfall finns följande konstruktion:

	try {
		... // Här gör vi något som kan kasta en exception
	} catch (Exception e) {
		... // Här tar vi hand om exceptionet - e är en referens till det exception som inträffat
	} finally {
		... // Detta är en kodsnutt som körs oavsett om en exception kastades eller inte
	}

Om man vill fånga olika sorters exception finns det två möjligheter. Antingen vill man göra samma sak för de olika fallen, då skriver man exempelvis:

	catch (IOException | NullPointerException e) {
		...
	}

Alternativt om man vill göra olika saker staplar man bara flera catch på varandra:

	catch (FileNotFoundException e) {
		... // Hantera att filen saknas
	}
	catch (IOException e) {
		... // Hantera generellt IO-fel
	}

Att notera är att java väljer den första catch som passar det exception som är aktuellt. FileNotFoundException är en subklass till IOException, vilket innebär att om man hade skrivit catch (IOException) först, hade den fångat både IOException och FileNotFoundException.

För mer information se [Java Essentials: Exceptions](http://docs.oracle.com/javase/tutorial/essential/exceptions/)

## Uppgift

Gör aktieportföljen mer robust genom att lägga in felhantering. Kanske finns det felfall som kan fångas och åtgärdas? Kanske ska försök att sälja fler aktier än vad man har resultera i en IllegalArgumentException?

