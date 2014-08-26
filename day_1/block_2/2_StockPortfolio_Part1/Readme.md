# Aktieportfölj del 1 - aktier

## Beskrivning

En aktie kan representeras av en klass med tre värden:

* Namn (t.ex. Ericsson B)
* Id (t.ex. ERIC B)
* Kurs (t.ex. 87,40 kr)

## Acceptanskriteria

### Aktieklass

	public class Stock {
		public Stock(String id, String name, double price) {
			...
		}
	}

### Testprogram

	public class Main {
		public static void main(String[] args) {
			Stock[] stocks = new Stock[] {
				new Stock("ERIC B", "Ericsson B", 87.40),
				new Stock("SKA B", "Skanska B", 145.90)
			};

			for (Stock stock : stocks) {
				System.out.println("Aktie: " + stock);
			}
		}
	}

Att köra testprogrammet ska ge följande utmatning:

> Aktie: Ericsson B (ERIC B) 87.40
>
> Aktie: Skanska B (SKA B) 145.90

## Hjälp

### Bestäm hur ett objekt omvandlas till sträng

Implementera metoden toString():

	public String toString() {
		return "...";
	}

Se även [Object.toString()](http://docs.oracle.com/javase/7/docs/api/java/lang/Object.html)



