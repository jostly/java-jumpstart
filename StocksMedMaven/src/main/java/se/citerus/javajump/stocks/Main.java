package se.citerus.javajump.stocks;

public class Main {
    public static void main(String[] args) {
    	Stock stock = new Stock("ERIC B", "Ericsson B", 80);

        Investment investment = new Investment(stock);

        investment.purchase(100);

        System.out.println("Inköpspris 1: " + investment.getPurchasePrice());
        
        stock.setPrice(89.00);

        System.out.println("Nytt värde: " + investment.getCurrentValue());
        
        investment.purchase(50);

        System.out.println("Inköpspris 2: " + investment.getPurchasePrice());
    }
}