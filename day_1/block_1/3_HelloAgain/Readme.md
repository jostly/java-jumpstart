# Hello Again

## Beskrivning

Läsa från standard input och tolka inmatningen.

## Acceptanskriterier

Program startas.

Förväntad utmatning:

> What's your name?

Inmatning:

> Joe

Förväntad utmatning:

> Hello, Joe.
>
> What's your name?

Inmatning:

> Robert

Förväntad utmatning:

> Hello, Robert.
>
> What's your name?

Inmatning:

>

(tryck enter utan att skriva något)

Förväntad utmatning:

> Bye.

Program avslutas.

## Hjälp

### Importera klasser från standardbibliotek

Högst upp i en fil (innan public class ...):

	import java.util.Random;

### Hitta vilka klasser som finns, och hur de används

[Java 8 API](https://docs.oracle.com/javase/8/docs/api/)

### Läsa textrad från standard input

Använd [Scanner](https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html)

	Scanner scanner = new Scanner(System.in);
	String line = scanner.nextLine();
	...
	scanner.close();
