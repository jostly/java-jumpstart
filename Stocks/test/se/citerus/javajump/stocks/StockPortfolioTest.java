package se.citerus.javajump.stocks;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

import static se.citerus.javajump.stocks.util.BigDecimalHelper.*;

public class StockPortfolioTest {
	StockRepository repository = new StockRepository();
	int ericssonPrice = 80;
	int teslaPrice = 120;

	@Before
	public void setup() {
		repository.add(new Stock("ERIC B", "Ericsson B", ericssonPrice));
		repository.add(new Stock("TSLA", "Tesla", teslaPrice));
	}

	@Test
	public void testPurchaseStock() {
		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", 100);

		assertThat(portfolio.getCurrentValue(), is(new BigDecimal("8000.00")));
	}

	@Test
	public void testPurchaseTwoSeparateStocks() {
		int ericssonAmount = 100;
		int teslaAmount = 10;

		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", ericssonAmount);
		portfolio.purchase("TSLA", teslaAmount);

		BigDecimal expectedValue = bd(ericssonPrice * ericssonAmount + teslaPrice * teslaAmount).setScale(2,
				RoundingMode.HALF_UP);

		assertThat(portfolio.getCurrentValue(), is(expectedValue));
	}

	@Test
	public void testMultiplePurchases() {
		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", 50);
		portfolio.purchase("ERIC B", 50);

		assertThat(portfolio.getCurrentValue(), is(new BigDecimal("8000.00")));
	}

	@Test
	public void testSellStocks() {
		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", 150);
		portfolio.sell("ERIC B", 50);

		assertThat(portfolio.getCurrentValue(), is(new BigDecimal("8000.00")));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSellingNotOwnedStockThrowsException() {
		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.sell("ERIC B", 50);
	}

	@Test
	public void testSavePortfolio() throws IOException {

		Portfolio portfolio = new StockPortfolio(repository);
		portfolio.purchase("ERIC B", 150);
		portfolio.purchase("TSLA", 50);

		StringWriter writer = new StringWriter();

		portfolio.save(writer);

		String expected = 
				"ERIC B;150;80.00\n" + 
				"TSLA;50;120.00\n";

		assertThat(writer.toString(), is(expected));
	}
	
	@Test
	public void testLoadPortfolio() throws IOException {
		Reader reader = new StringReader("ERIC B;150;80.00\nTSLA;50;120.00\n");
		
		StockPortfolio portfolio = (StockPortfolio) StockPortfolio.load(reader, repository);

		assertThat(portfolio, is(notNullValue()));

		List<Investment> investments = portfolio.investments();
		
		assertThat(investments.size(), is(2));
		
		assertThat(investments.get(0).stock.id, is("ERIC B"));
		assertThat(investments.get(0).getAmount(), is(150));
		assertThat(investments.get(0).getPurchasePrice(), is(bd("80.00")));
	
		assertThat(investments.get(1).stock.id, is("TSLA"));
		assertThat(investments.get(1).getAmount(), is(50));
		assertThat(investments.get(1).getPurchasePrice(), is(bd("120.00")));			
	}

}
