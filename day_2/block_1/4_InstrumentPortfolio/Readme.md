# Värdepapperportfölj del 1

## Beskrivning

Nu önskar kunderna även spara fondinnehav i portföljen. Detta kräver att ett innehav antingen kan vara en fond eller en aktie - skillnaden är att fondandelar inte behöver vara heltal

## Acceptanskritera

### Klasshierarki

Ett värdepapper (Financial instrument) är samlingsnamn för både aktier och fonder:

	public interface FinancialInstrument {
		String getId();
		double getPrice();
	}

Låt Stock implementera FinancialInstrument.

Skapa en klass för fonder:

	public class Fund implements FinancialInstrument {
		...
	}

Nu ska Investment behandla FinancialInstrument istället för Stock. Portfolio behöver sannolikt
inte ändras förutom att mängden av ett finansiellt instrument man kan köpa inte längre bara kan vara heltal.

### Testprogram

	public class Main {
		public static void main(String[] args) {
			FinancialInstrument ericB = new Stock("ERIC B", "Ericsson B", 80.0);
			FinancialInstrument fond = new Fund("RFS", "Räntefond Sverige", 950.0);

			Portfolio portfolio = new Portfolio();

			portfolio.purchase(ericB, 100);
			portfolio.purchase(fond, 2.5);

			System.out.println(portfolio.toString());
		}
	}

Att köra testprogrammet ska ge följande utmatning (nu skriver vi ut namnet istället för id)

> Ericsson B 100 @ 80.0: 8000.0
>
> Räntefond Sverige 2.5 @ 950.0: 2375.0


