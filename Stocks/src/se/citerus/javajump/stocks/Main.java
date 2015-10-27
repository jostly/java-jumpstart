package se.citerus.javajump.stocks;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.logging.*;

import se.citerus.javajump.stocks.exception.InvestmentParseException;

public class Main {
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName()); 
	
    public static void main(String[] args) {
    	StockRepository repository = new StockRepository();
		repository.add(new Stock("ERIC B", "Ericsson B", 80));
		repository.add(new Stock("TSLA", "Tesla", 110));
		
		try {
	    	InputStream portfolioStream = Main.class.getResourceAsStream("/reference/defaultPortfolio.csv");
	    	
			InputStreamReader reader = new InputStreamReader(portfolioStream);
	    	Portfolio portfolio = StockPortfolio.load(reader, repository);    	
		} catch (InvestmentParseException e) {
			LOGGER.log(Level.SEVERE, "Portfolio file parsing error", e);
			System.out.println("Your portfolio file is corrupt. Restore it from backup.");
		}
    }
}