package org.siit;

public enum BinaryOperator {
	
	ADD("+", "added with"),
	SUBSTRACT("-", "substracted by"),
	MULTIPLY("*", "multiplied by"),
	DIVIDE("/", "divided by"),
	MODULUS("%", "modulo to");
	
	private final String symbol;
	private final String verb;

	BinaryOperator(String symbol, String word) {
		this.symbol = symbol;
		this.verb = word;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getVerb() {
		return verb;
	}
}
