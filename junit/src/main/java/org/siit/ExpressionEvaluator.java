package org.siit;


import java.util.List;

public class ExpressionEvaluator {
	
	public static int evaluate(Expression expression) {
		List<Object> elements = expression.getElements();
		int result = (int) elements.get(0);
		BinaryOperator operator;
		int operand;
		for(int i =2; i< elements.size();i+=2){
			operator = (BinaryOperator) elements.get(i-1);
			operand = (int) elements.get(i);
			result = evalBinary(operator,result,operand);
		}
		return result;
	}
	
	public static Integer evalBinary(
			String operator, Integer left, Integer right) {
		switch (operator) {
		case "+":
			return left + right;
		case "-":
			return left - right;
		case "*":
			return left * right;
		case "/":
			return left / right;
		case "%":
			return left % right;
		default:
			throw new ValidationException(
					"Operator '" + operator + "' is not known");
		}
	}
	
	public static Integer evalBinary(
			BinaryOperator op, Integer left, Integer right) {
		switch (op) {
		case ADD:
			return left + right;
		case SUBSTRACT:
			return left - right;
		case MULTIPLY:
			return left * right;
		case DIVIDE:
			return left / right;
		case MODULUS:
			return left % right;
		default:
			throw new ValidationException(
					"Operator '" + op + "' is not known");
		}
	}
	
}
