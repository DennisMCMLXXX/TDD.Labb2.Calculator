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
	 
	/**
	 * Anledningen till att det är flera test´s och inte ett med @Parameters är att jag har en avrundare
	 * som lägger till ",0" som förväntat resultat. Det hade gått att lösa genom en regex men nu blev
	 * det såhär istället.
	 */
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
	
	@Test
	public void featureTestNrThree() {
		String input = "5+9-8*90/3+6!";
		String actual = calc.calculateExpression(input);
		assertEquals("494,0",actual);
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
	    	"3++5, Wrong parameter order",
	    	"*+6-5, Wrong parameter order",
	    	"**65, Wrong parameter order",
	    	"39//, Wrong parameter order"
		})
	    public void featureTestParameters(String input, String expected) {
	    	String actual = calc.calculateExpression(input);
	    	assertEquals(expected, actual);
	    }
	 
	 @Test
	 public void subtractionSixMinusMinusThreeEqualsNine() {
		 String input = "6--3";
		 String actual = calc.calculateExpression(input);
		 assertEquals ("9,0", actual);
	 }
	 
	 //extra test då featureTestParameters har krånglat en del för mig i eclipse
	 @Test(expected = ArithmeticException.class)
	 public void twoWrongParameters () {
		 String input = "3++4";
		 String actual = calc.calculateExpression(input);
		 assertEquals ("Wrong parameter order", actual); 
	 }
	 @Test(expected = ArithmeticException.class)
	 public void containsCharacters() {
		 String input = "sdf";
		 String actual = calc.calculateExpression(input);
		 assertEquals("String can not contain characters", actual);
	 }
	 
	 @Test(expected = ArithmeticException.class)
	 public void parameterFirst() {
		 String input = "*3";
		 String actual = calc.calculateExpression(input);
		 assertEquals("Equation can not start with a parameter", actual);
	 }
	 @Test(expected = ArithmeticException.class)
	 public void parameterLast() {
		 String input = "3*";
		 String actual = calc.calculateExpression(input);
		 assertEquals("Equation can not end with a parameter", actual);
	 }
	 @Test(expected = ArithmeticException.class)
	 public void emptyString() {
		 String input = "";
		 String actual = calc.calculateExpression(input);
		 assertEquals("String is empty", actual);
	 }
	 
	 @Test
	 public void multiplicationBigNumber() {
		 String input = "10000000*10000000*10000000";
		 String actual = calc.calculateExpression(input);
		 assertEquals("1000000000000000000000,0", actual);
	 }
	  
	 @Test
	 public void factorialTest(){
		 String input = "5!";
		 String actual = calc.calculateExpression(input);
		 assertEquals("120,0", actual);
	 }
	 
	 @Test
	 public void factorialWithOthers() {
		 String input = "5*5+5!";
		 String actual = calc.calculateExpression(input);
		 assertEquals("145,0", actual);
		 
	 }
}
