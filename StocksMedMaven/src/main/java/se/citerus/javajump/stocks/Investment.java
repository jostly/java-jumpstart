package se.citerus.javajump.stocks;

import java.math.BigDecimal;

public class Investment {
	public final Stock stock;
	private int amount;

	public Investment(Stock stock) {
		this.stock = stock;
	}

	public void purchase(int a) {
		amount += a;
	}

	public BigDecimal getPurchasePrice() {
		return stock.getPrice();
	}

	public BigDecimal getCurrentValue() {
		return stock.getPrice().multiply(new BigDecimal(amount));
	}

}
