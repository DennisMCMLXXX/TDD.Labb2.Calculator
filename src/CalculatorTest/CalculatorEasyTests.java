package CalculatorTest;

import Calculator.Calculator;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
@RunWith(JUnitParamsRunner.class)
public class CalculatorEasyTests{

    Calculator calc;

    @Before
    public void beforeEachTest() {
        calc = new Calculator();
    }
   
    @Test
    public void additionOnePlusOneEqualsTwo(){
        String input = "1+1";
        String acutal = calc.calculateExpression(input);
        assertEquals("2,0", acutal);
    }

  @Test
    public void multiplyTwoTimesFourEqualsEight(){
        String input = "2*4";
        String actual = calc.calculateExpression(input);
        assertEquals("8,0", actual);
    }

    @Test
    public void subtractionTwoMinusOneEqualsOne() {
    	String input = "2-1";
    	String actual = calc.calculateExpression(input);
    	assertEquals ("1,0", actual);
    }

    @Test
    public void divisionSixDividedByTwoEqualsThree() {
    	String input = "6/2";
    	String actual = calc.calculateExpression(input);
    	assertEquals ("3,0", actual);
    }
    
    @Test
    public void moduloSixModuloFourEqualsTwo() {
    	String input = "6%4";
    	String actual = calc.calculateExpression(input);
    	assertEquals ("2,0", actual);
    }
    
    @Test
    public void testAdditionMultiplyInRinghtOrder(){
        String input = "4*5+3";
        String actual = calc.calculateExpression(input);
        assertEquals("23,0", actual);
    }
    
    @Test
    public void testSubtractionMultiplyInRightOrder() {
    	String input = "50-2*5";
    	String actual = calc.calculateExpression(input);
    	assertEquals("40,0", actual);
    }
    
    @Test
    public void testDivisionSubtractionInRightOrder() {
    	String input = "30-10/2";
    	String actual = calc.calculateExpression(input);
    	assertEquals("25,0", actual);
    }

    
}
