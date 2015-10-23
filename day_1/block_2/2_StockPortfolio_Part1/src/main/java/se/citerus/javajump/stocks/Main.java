package se.citerus.javajump.stocks;

public class Main {
    public static void main(String[] args) {
        Stock[] stocks = new Stock[] {
            new Stock("ERIC B", "Ericsson B", 87.40),
            new Stock("SKA B", "Skanska B", 145.90)
        };

        for (Stock stock : stocks) {
            System.out.println("Aktie: " + stock);
        }
    }
}