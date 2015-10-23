package se.citerus.javajump.stocks;

public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock("ERIC B", "Ericsson B", 80);

        Investment investment = new Investment(stock);

        investment.purchase(100);

        System.out.println("Inköpspris 1: " + investment.getPurchasePrice());

        stock.setPrice(89);

        System.out.println("Nytt värde: " + investment.getCurrentValue());

        investment.purchase(50);

        System.out.println("Inköpspris 2: " + investment.getPurchasePrice());

        System.out.println("Nytt värde: " + investment.getCurrentValue());

        investment.sell(75);

        System.out.println("Inköpspris efter försäljning: " + investment.getPurchasePrice());

        System.out.println("Antal efter försäljning: " + investment.getAmount());

        System.out.println("Nytt värde: " + investment.getCurrentValue());

    }
}
