# Hello Commandline

## Beskrivning

Läsa argument från kommandoraden, och behandla dem.

## Acceptanskriterier 

### Ett argument

Kör på kommandoraden:

> java HelloCommandline Joe

Förväntad utmatning:

> Hello, Joe.

### Flera argument

Kör på kommandoraden:

> java HelloCommandline Alice Bob Celine

Förväntad utmatning:

> Hello, Alice.
>
> Hello, Bob.
>
> Hello, Celine.

## Hjälp

### Läsa argument till programmet

	public static void main(String[] args) {
		...
	}

args är en array med inparametrar till programmet

### Hur många element finns det i en array?

	int numberOfElements = theArray.length;

### Räkna från 0 till 99 

	for (int i = 0; i < 100; i += 1) {
		...
	}

