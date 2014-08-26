# Aktieportfölj del 2 - innehav

## Beskrivning

Ett innehav av en aktie är en referens till en aktie, ett antal och ett inköpspris som är ett viktat medelvärde av kursen då aktierna köptes (vilket kan ha skett i olika omgångar). Den kan också räkna ut nuvarande värde baserat på antal aktier och aktiens aktuella kurs.

Inköpspriset beräknas enligt:

	nytt inköpspris = (ägda aktier * gammalt inköpspris + köpta aktier * köpkurs) / (ägda aktier + köpta aktier)

## Acceptanskriteria

### Innehavsklass

	public class Investment {
		...
	}

### Testprogram

	public class Main {
		public static void main(String[] args) {
			Stock stock = new Stock("ERIC B", "Ericsson B", 80);

			Investment investment = new Investment(stock);

			investment.purchase(100);

			System.out.println("Inköpspris 1: " + investment.getPurchasePrice());

			stock.setPrice(89);

			System.out.println("Nytt värde: " + investment.getCurrentValue());

			investment.purchase(50);

			System.out.println("Inköpspris 2: " + investment.getPurchasePrice());

			System.out.println("Nytt värde: " + investment.getCurrentValue());

			investment.sell(75);

			System.out.println("Inköpspris efter försäljning: " + investment.getPurchasePrice());

			System.out.println("Antal efter försäljning: " + investment.getAmount());

			System.out.println("Nytt värde: " + investment.getCurrentValue());

		}
	}

Att köra testprogrammet ska ge följande utmatning:

> Inköpspris 1: 80.0
>
> Nytt värde: 8900.0
>
> Inköpspris 2: 83.0
>
> Nytt värde: 12450.0
>
> Inköpspris efter försäljning: 83.0
>
> Antal efter försäljning: 75
>
> Nytt värde: 6225.0



