package se.citerus.javajump.stocks;

import java.math.BigDecimal;

import se.citerus.javajump.stocks.exception.InvestmentParseException;

import static se.citerus.javajump.stocks.util.BigDecimalHelper.*;

public class Investment implements Comparable<Investment> {
	public final Stock stock;
	private int amount;
	private BigDecimal purchasePrice = BigDecimal.ZERO;

	public Investment(Stock stock) {
		this.stock = stock;
	}

	public void increase(int purchasedAmount) {
		BigDecimal previousValue = mul(purchasePrice, amount);
		BigDecimal purchasedValue = mul(stock.getPrice(), purchasedAmount);
		amount += purchasedAmount;
		purchasePrice = previousValue.add(purchasedValue).divide(bd(amount));
	}
	
	public BigDecimal getPurchasePrice() {
		return purchasePrice;
	}

	public BigDecimal getCurrentValue() {
		return stock.getPrice().multiply(new BigDecimal(amount));
	}

	public void decrease(int soldAmount) {
		amount -= soldAmount;
	}

	public String convertToCSV() {
		return stock.id + ";" + amount + ";" + purchasePrice;
	}

	public int getAmount() {
		return amount;
	}

	public static Investment convertFromCSV(String csv, StockRepository repository) {
		try {
			String[] split = csv.split(";");
			String stockId = split[0];
			int amount = Integer.parseInt(split[1]);
			BigDecimal purchasePrice = new BigDecimal(split[2]);
			
			Stock stock = repository.find(stockId);
			Investment investment = new Investment(stock);
			investment.amount = amount;
			investment.purchasePrice = purchasePrice;
			
			return investment;
		} catch (Exception e) {
			throw new InvestmentParseException("Cannot parse investment from csv: '" + csv + "'", e);
		}
	}

	@Override
	public int compareTo(Investment o) {
		return stock.id.compareTo(o.stock.id);
	}

}
