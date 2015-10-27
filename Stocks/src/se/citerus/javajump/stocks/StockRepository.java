package se.citerus.javajump.stocks;

import java.util.HashMap;
import java.util.Map;

public class StockRepository {
	
	private Map<String, Stock> stocks = new HashMap<>();

	public void add(Stock stock) {
		stocks.put(stock.id, stock);
	}
	
	public Stock find(String id) {
		return stocks.get(id);
	}

}
