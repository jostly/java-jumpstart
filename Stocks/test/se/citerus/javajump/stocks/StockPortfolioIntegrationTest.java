package se.citerus.javajump.stocks;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static se.citerus.javajump.stocks.util.BigDecimalHelper.*;

public class StockPortfolioIntegrationTest {
	StockRepository repository = new StockRepository();
	int ericssonPrice = 80;
	int teslaPrice = 120;
	
	Path tempFile;

	@Before
	public void setup() throws IOException {
		repository.add(new Stock("ERIC B", "Ericsson B", ericssonPrice));
		repository.add(new Stock("TSLA", "Tesla", teslaPrice));
		tempFile = Files.createTempFile("stockportfoliotest", ".csv");
	}
	
	@After
	public void cleanup() {
		try {
			Files.delete(tempFile);
		} catch (IOException e) {
		}
	}
	
	@Test
	public void testSaveAndLoadPortfolio() throws Exception {
		
		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", 150);
		portfolio.purchase("TSLA", 50);

		try(Writer writer = Files.newBufferedWriter(tempFile)) {
			portfolio.save(writer);
		}
		
		try(Reader reader = Files.newBufferedReader(tempFile)) {
			Portfolio loaded = StockPortfolio.load(reader, repository);
			
			assertThat(loaded.getCurrentValue(), is(portfolio.getCurrentValue()));
		}
		
	}

}
