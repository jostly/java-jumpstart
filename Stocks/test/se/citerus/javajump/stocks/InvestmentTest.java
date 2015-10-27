package se.citerus.javajump.stocks;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import se.citerus.javajump.stocks.exception.InvestmentParseException;

import static se.citerus.javajump.stocks.util.BigDecimalHelper.*;

public class InvestmentTest {
	Stock stock;
	Investment investment;
	
	@Before
	public void setup() {
		stock = new Stock("ERIC B", "Ericsson B", 80);
		investment = new Investment(stock);
		investment.increase(100);
	}
	
	@Test(expected = InvestmentParseException.class)
	public void testParseExceptionThrown() {
		Investment.convertFromCSV("blah", new StockRepository());
	}

	@Test
	public void testCurrentValue() {
		
		assertThat(investment.getCurrentValue(), is(bd("8000.00")));
	}
	
	@Test
	public void testPurchasePriceAfterOnePurchase() {

		assertThat(investment.getPurchasePrice(), is(bd("80.00")));
		
	}
	
	@Test
	public void testPurchasePriceAfterTwoPurchases() {
		stock.setPrice(90);
		investment.increase(100);
		assertThat(investment.getPurchasePrice(), is(bd("85.00")));
	}
	
	@Test
	public void testSell() {
		investment.decrease(50);
		
		assertThat(investment.getCurrentValue(), is(bd("4000.00")));
		assertThat(investment.getPurchasePrice(), is(bd("80.00")));
	}
	
	@Test
	public void testSerializeInvestment() {
		String expected = "ERIC B;100;80.00";
		
		assertThat(investment.convertToCSV(), is(expected));
	}
	
	@Test
	public void testDeserializeInvestment() {
		StockRepository repository = new StockRepository();
		repository.add(new Stock("TSLA", "Tesla", 120));		

		String csv = "TSLA;75;105.00";
		
		Investment inv = Investment.convertFromCSV(csv, repository);
		
		assertThat(inv, is(notNullValue()));
		assertThat(inv.stock.id, is("TSLA"));
		assertThat(inv.getAmount(), is(75));
		assertThat(inv.getPurchasePrice(), is(bd("105.00")));
	}
}
