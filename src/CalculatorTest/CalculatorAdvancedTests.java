package CalculatorTest;

import Calculator.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
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
	    @Ignore
	    @Test
	    @Parameters({
	    	"3,3,3,3,3,3"
		})
	    public void featureTests(String a, String b, String c, String d, String e, String expected) {
	    	String input = a+"*"+b+"/"+c+"+"+d+"-"+e;
	    	String actual = calc.calculateExpression(input);
	    	assertEquals(expected, actual);
	    	//fler asserts!
	    }
	 
	 @Test
	 public void subtractionSixMinusMinusThreeEqualsNine() {
		 String input = "6--3";
		 String actual = calc.calculateExpression(input);
		 assertEquals ("9,0", actual);
	 }
}
