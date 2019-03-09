package CalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Calculator.Calculator;
import Calculator.CalculatorTWO;

public class CalculatorAdvancedTests {

	CalculatorTWO calc;
	
	 @Before
	 public void beforeEachTest() {
	 calc = new CalculatorTWO();
	 }
	 @Ignore
	@Test
	public void test() {
		String input = "2+5-6*3/5";
		String actual = calc.calculateExpression(input);
		assertEquals("3.4",actual);
		
	}
}
