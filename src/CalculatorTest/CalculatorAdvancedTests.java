package CalculatorTest;

import Calculator.Calculator;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class CalculatorAdvancedTests {

	Calculator calc;
	
	 @Before
	 public void beforeEachTest() {
	 calc = new Calculator();
	 }
	
	@Test
	public void featureTestNrOne() {
		String input = "5*4+7-3*0+4-10";
		String actual = calc.calculateExpression(input);
		assertEquals("21,0",actual);
	}
	@Test
	public void featureTestNrTwo() {
		String input = "7*4+6-3/2";
		String actual = calc.calculateExpression(input);
		assertEquals("32,5",actual);
	}
	
	 @Test(expected = ArithmeticException.class)
	 public void testTwoEmptyTwoThrowsArithmeticExpression() {
		 String input = "2 2";
		 String actual = calc.calculateExpression(input);
		 assertEquals (new ArithmeticException("Mathematic expression needed"), actual);
	 }
	 
	 @Test(expected = ArithmeticException.class)
	 public void testFortytwoDividedByZeroThrowsArithmeticExpression() {
		 String input = "42/0";
		 String actual = calc.calculateExpression(input);
		 assertEquals (new ArithmeticException("You can not divide by zero!"), actual);
	 }
	  
	  @Test(expected = ArithmeticException.class)
	  public void StringContainsBlankspace() {
		  String input = " 2+ 2";
		  String actual = calc.calculateExpression(input);
		  assertEquals("Contains blankspaces!", actual);
	    }
	  
	    @Test(expected = ArithmeticException.class)
	    @Parameters({
	    	"3, +, +, 5, Wrong parameter order",
	    	"*, +, 6, 5, Wrong parameter order",
	    	"*, *, 6, 5, Wrong parameter order",
	    	"3, 9, /, /, Wrong parameter order"
		})
	    public void featureTestParameters(String a, String b, String c, String d, String expected) {
	    	String input = a+b+c+d;
	    	String actual = calc.calculateExpression(input);
	    	assertEquals(expected, actual);
	    }
	 
	 @Test
	 public void subtractionSixMinusMinusThreeEqualsNine() {
		 String input = "6--3";
		 String actual = calc.calculateExpression(input);
		 assertEquals ("9,0", actual);
	 }
	 
	 //extra test då featureTestParameters har krånglat en hel del
	 @Test(expected = ArithmeticException.class)
	 public void twoWrongParameters () {
		 String input = "3++4";
		 String actual = calc.calculateExpression(input);
		 assertEquals ("Wrong parameter order", actual); 
	 }
	 @Test(expected = ArithmeticException.class)
	 public void containsCharacters() {
		 String input = "asf";
		 String actual = calc.calculateExpression(input);
		 assertEquals("String can not contain characters", actual);
	 }
	 
	 @Test(expected = ArithmeticException.class)
	 public void parameterFirst() {
		 String input = "*3";
		 String actual = calc.calculateExpression(input);
		 assertEquals("Equation can not start with a parameter", actual);
	 }
}
