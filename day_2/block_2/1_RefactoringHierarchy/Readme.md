# Refaktorera klasshierarki

Vid det här laget har Stock och Fund säkerligen en del kod duplicerad, till exempel priset som kan variera.

FinancialInstrument är ett interface, och det går inte att lägga state eller kod i det (ändras till viss del i Java 8, läs gärna på om det vid tillfälle)

Skapa därför en gemensam basklass för Stock och Fund, exempelvis med namnet AbstractFinancialInstrument:


	public abstract class AbstractFinancialInstrument implements FinancialInstrument {

		public double getPrice() { ... }
		public void setPrice() { ... }

	}

Att klassen är abstract betyder dels att den inte går att instansiera direkt - och dels att den inte behöver implementera alla metoder i interfacet FinancialInstrument.

Därefter kan Fund och Stock båda ärva från AbstractFinancialInstrument:

	public class Stock extends AbstractFinancialInstrument {
		...
	}

och därmed få price-hanteringen gratis. Det går även att göra detta med id-begreppet.

## Varför ens ha Stock och Fund separata?

Det går utmärkt i det här fallet att argumentera för att det är onödigt att ha Stock och Fund som separata klasser - båda har samma innehåll och åtskillnad mellan dem skulle kunna vara en flagga i en gemensam klass istället.

Se det som ett sätt att få prova på interface, abstrakta klasser och arv, mer än ett exempel på hur man skulle gjort i ett verkligt fall. Den som vill kan naturligtvis hitta på någon extra egenskap för antingen aktier eller fonder som motiverar egna klasser.

