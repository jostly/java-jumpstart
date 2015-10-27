package se.citerus.javajump.stocks;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Stock {
	public final String id;
	private String name;
	private BigDecimal price;
	// 
	/* */
	public Stock(String id, String name, double price) {
		this.id = id;
		this.name = name;
		setPrice(price);
	}
	
	public Stock(String id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		setPrice(price);
	}

	@Override
	public String toString() {
		return String.format("%s (%s) %.2f", name, id, price);
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price must be positive");
		}
		this.price = new BigDecimal(price).setScale(2, RoundingMode.HALF_UP);
	}
}
