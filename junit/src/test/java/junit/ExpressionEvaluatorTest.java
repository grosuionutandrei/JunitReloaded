package junit;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.siit.BinaryOperator;
import org.siit.Expression;
import org.siit.ExpressionEvaluator;

public class ExpressionEvaluatorTest {

	private static int evaluate(Object... elem) {
		List<Object> elements = Arrays.asList(elem);
		Expression expr = Mockito.mock(Expression.class);
		Mockito.when(expr.getElements()).thenReturn(elements);
		return ExpressionEvaluator.evaluate(expr);
	}
	
	@Test
	public void testZeroConstant() {
		Assert.assertEquals(
				0, evaluate(0));
	}
	
	@Test
	public void testFiveConstant() {
		Assert.assertEquals(
				5, evaluate(5));
	}
	
	@Test
	public void testMultiDigitConstant() {
		Assert.assertEquals(
				44232, evaluate(44232));
	}
	
	@Test
	public void testSimpleAddition() {
		Assert.assertEquals(
				5, evaluate(3, BinaryOperator.ADD, 2));
	}
	
}
