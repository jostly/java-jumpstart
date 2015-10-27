package se.citerus.javajump.stocks;

public class Stock {
	private String id;
	private String name;
	private double price;
	
    public Stock(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    
    @Override
    public String toString() {
    	return String.format("%s (%s) %.2f", name, id, price);
    }

	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
