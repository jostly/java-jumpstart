package se.citerus.javajump.stocks;

import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;

public interface Portfolio {
	void purchase(String id, int amount);
	void sell(String id, int amount);
	BigDecimal getCurrentValue();
	void save(Writer writer) throws IOException;
}
