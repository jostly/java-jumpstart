package se.citerus.javajump.stocks;

public class Main {
    public static void main(String[] args) {
        Stock ericB = new Stock("ERIC B", "Ericsson B", 80);
        Stock skaB = new Stock("SKA B", "Skanska B", 140);

        Portfolio portfolio = new Portfolio();

        portfolio.purchase(ericB, 100);

        System.out.println(portfolio.toString());
        System.out.println("---");

        portfolio.purchase(skaB, 50);

        System.out.println(portfolio.toString());
        System.out.println("---");

        portfolio.sell(ericB, 50);

        System.out.println(portfolio.toString());

    }
}