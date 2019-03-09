package CalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Calculator.Calculator;

public class CalculatorMediumTests {

	Calculator calc;
	
	 @Before
	 public void beforeEachTest() {
	 calc = new Calculator();
	 }
	 
	  
	 @Test
	 public void additionOnePlusOnePlusOneEqualsThree(){
		 String input = "1+1+1";
		 String actual = calc.calculateExpression(input);
		 assertEquals("3,0", actual);
	    }
	 @Test
	 public void subtractionFiftyfivemMinusFiveMinusEightEqualsFoutytwo(){
		 String input = "55-5-8";
		 String actual = calc.calculateExpression(input);
		 assertEquals("42,0", actual);
	    }
	 
	 @Test
	 public void test() {
		 String input = "2*3*4*5";
		 String actual = calc.calculateExpression(input);
	 	 assertEquals("120,0",actual);
			
		}
}
