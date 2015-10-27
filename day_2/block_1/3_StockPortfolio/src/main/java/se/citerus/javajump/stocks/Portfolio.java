package se.citerus.javajump.stocks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Portfolio {
	
	private Map<Stock, Investment> investments = new HashMap<>();

	public void purchase(Stock stock, int amount) {
		Investment investment = investments.computeIfAbsent(stock, s -> new Investment(s));
		investment.purchase(amount);
	}

	public void sell(Stock stock, int amount) {
		Investment investment = investments.get(stock);
		investment.sell(amount);
	}
	
	@Override
	public String toString() {
		return investments
				.entrySet()
				.stream()
				.map(e -> String.format("%s %d @ %.2f: %.2f", e.getKey().id, e.getValue().getAmount(), e.getValue().getPurchasePrice(), e.getValue().getCurrentValue()))
				.collect(Collectors.joining("\n"));
	}

}
