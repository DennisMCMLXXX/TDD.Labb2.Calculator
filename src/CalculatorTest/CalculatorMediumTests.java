package CalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Calculator.Calculator;

public class CalculatorMediumTests {


    private static final double DELTA = 0.111;

	Calculator calc;
	
	 @Before
	 public void beforeEachTest() {
	 calc = new Calculator();
	 }
	
	 @Test
		public void test() {
			String input = "2*3*4*5";
			double actual = calc.calculateExpression(input);
			assertEquals(120d,actual, DELTA);
			
		}
}
