# Aktieportfölj del 3 - portfölj

## Beskrivning

En aktieportfölj är en samling av innehav, med möjlighet att köpa och sälja aktier ur innehavet

## Acceptanskriteria

### Portföljklass

	public class Portfolio {
		...
	}

### Metoder

	public void purchase(Stock stock, int amount)

	public void sell(Stock stock, int amount)

### Testprogram

	public class Main {
		public static void main(String[] args) {
			Stock ericB = new Stock("ERIC B", "Ericsson B", 80);
			Stock skaB = new Stock("SKA B", "Skanska B", 140);

			Portfolio portfolio = new Portfolio();

			portfolio.purchase(ericB, 100);

			System.out.println(portfolio.toString());
			System.out.println("---");

			portfolio.purchase(skaB, 50);

			System.out.println(portfolio.toString());
			System.out.println("---");

			portfolio.sell(ericB, 50);

			System.out.println(portfolio.toString());

		}
	}

Att köra testprogrammet ska ge följande utmatning (ordningen i vilken aktierna i en portfölj listas är oviktig):

> ERIC B 100 @ 80.0: 8000.0
>
> ---
>
> ERIC B 100 @ 80.0: 8000.0
>
> SKA B 50 @ 140.0: 7000.0
>
> ---
>
> ERIC B 50 @ 80.0: 4000.0
>
> SKA B 50 @ 140.0: 7000.0


