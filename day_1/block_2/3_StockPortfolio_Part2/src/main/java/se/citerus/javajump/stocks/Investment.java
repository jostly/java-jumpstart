package se.citerus.javajump.stocks;

public class Investment {
	private Stock stock;
	private int amount;
	private double purchasePrice;

	public Investment(Stock stock) {
		this.stock = stock;
	}

	public void purchase(int purchased) {
		purchasePrice = (purchasePrice * amount + purchased * stock.getPrice()) / (amount + purchased); 
		amount += purchased;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public double getCurrentValue() {
		return amount * stock.getPrice();
	}

	public int getAmount() {
		return amount;
	}

	public void sell(int i) {
		amount -= i;
	}		
}
