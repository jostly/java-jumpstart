package se.citerus.javajump.stocks.util;

import java.math.BigDecimal;

public class BigDecimalHelper {
	public static BigDecimal bd(double a) {
		return new BigDecimal(a);
	}

	public static BigDecimal bd(String a) {
		return new BigDecimal(a);
	}

	public static BigDecimal mul(BigDecimal a, double b) {
		return a.multiply(bd(b));
	}
}
