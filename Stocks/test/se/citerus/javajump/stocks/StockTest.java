package se.citerus.javajump.stocks;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class StockTest {

	@Test
	public void testSettingPrice() {
		Stock stock = new Stock("", "", 0);
		
		stock.setPrice(12.34);
		
		assertThat(stock.getPrice(), is(new BigDecimal("12.34")));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSettingNegativePrice() {
		Stock stock = new Stock("", "", 0);
		
		stock.setPrice(-12.34);		

		assertThat(stock.getPrice(), is(new BigDecimal("0.00")));
	}

}
