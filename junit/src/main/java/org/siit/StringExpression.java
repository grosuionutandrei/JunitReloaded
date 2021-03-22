package org.siit;

import java.util.ArrayList;
import java.util.List;

public class StringExpression implements Expression {
	
	private List<Object> elements;
	
	public StringExpression(String expression) {
		String[] tokens = expression.trim().split("\\s+");
		elements = new ArrayList<>();

		
		for (int i=0; i<tokens.length; ++i) {
			elements.add(i%2==0
					? readAsNumber(tokens[i]) 
					: readAsBinaryOperator(tokens[i]);
		}
		if(elements.size()%2==0){
			throw new ValidationException("Number of tokens is incorrect");
		}
	}
	
	public static Integer readAsNumber(String s) {
		if (s.length() == 0) {
			throw new ValidationException(
					"No value was entered");
		}
		if ( ! isNumber(s) ) {
			throw new ValidationException(
					"Value '" + s + "' is not a number");
		}

		return Integer.parseInt(s);
	}

	public static BinaryOperator readAsBinaryOperator(String s){
		if(s.length()==0){
			throw new ValidationException("No value was entered");
		}
		if(!isBinaryOperator(s)){
			throw new ValidationException("Value '" +s +  " is not a binary ");
		}
		switch (s) {
			case "+":
				return BinaryOperator.ADD;
			case "-":
				return BinaryOperator.SUBSTRACT;
			case "*":
				return BinaryOperator.MULTIPLY;
			case "%":
				return BinaryOperator.MODULUS;
		}
		return BinaryOperator.DIVIDE;

	}
	public static boolean isBinaryOperator(String string ){
		try {
			BinaryOperator[] binaryOperators = BinaryOperator.values();
			for(BinaryOperator binary : binaryOperators){
				if(string.equals(binary.getSymbol())){
					return true;
				}
			}
			return  false;
		}catch (RuntimeException e){
			throw new RuntimeException(
					"Error checking if '" + string + "' is a Binary operator " , e );
		}
	}
	
	public static boolean isNumber(String str) {
		try {
			//the next commented line is intentionally incorrect 
			//so exception causes and re-throw can be tested 
			//for (int i=0; i<=str.length(); ++i) {
			for (int i=0; i<str.length(); ++i) {
				if ( ! Character.isDigit(str.charAt(i))) {
					return false;
				}
			}
			return true;
		} catch (RuntimeException e) {
			throw new RuntimeException(
					"Error checking if '" + str + "' is a digit", e);
		}
		
	}

	public List<Object> getElements() {
		return elements;
	}
}
