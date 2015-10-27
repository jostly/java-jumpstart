package se.citerus.javajump.stocks;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StockPortfolio implements Portfolio {

	private StockRepository repository;
	private Map<String, Investment> investments = new HashMap<>();
	
	public StockPortfolio(StockRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public void purchase(String id, int amount) {
		Investment investment = investments.computeIfAbsent(id, 
				stockId -> new Investment(repository.find(stockId))
				); 
		
		investment.increase(amount);
	}

	@Override
	public void sell(String id, int amount) {
		Investment investment = investments.get(id);
		if (investment == null) {
			throw new IllegalArgumentException("No stock " + id + " owned.");
		} else {
			investment.decrease(amount);			
		}
	}

	@Override
	public BigDecimal getCurrentValue() {
		BigDecimal value = BigDecimal.ZERO;
		for (Investment i : investments.values()) {
			value = value.add(i.getCurrentValue());
		}
		return value;
	}

	@Override
	public void save(Writer writer) throws IOException {		
		for (Investment i : investments()) {
			writer.write(i.convertToCSV() + "\n");
		}		
	}

	public static Portfolio load(Reader reader, StockRepository repository) {
		StockPortfolio portfolio = new StockPortfolio(repository);
		//
		try(Scanner scanner = new Scanner(reader)) {
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				Investment investment = Investment.convertFromCSV(line, repository);
				portfolio.investments.put(investment.stock.id, investment);
			}
		}
		//
		return portfolio;
	}

	List<Investment> investments() {
		List<Investment> list = new ArrayList<>(investments.values());
		Collections.sort(list);
		return list;
	}
}
