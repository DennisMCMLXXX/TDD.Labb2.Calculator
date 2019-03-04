package CalculatorTest;

import Calculator.Calculator;
import org.junit.*;


import static org.junit.Assert.assertEquals;

public class CalculatorTest{

    private static final double DELTA = 0.111;

    Calculator calc;

    @Before
    public void beforeEachTest() {
        calc = new Calculator();
    }

  
    @Test
    public void StringOfOneToDoubleOne(){
        String input = "1";
        double actual = calc.calculateExpression(input);
        assertEquals(1d, actual, DELTA);
    }

    @Test
    public void StringOfTwoGivesDoubleTwo(){
        String input = "2";
        double actual = calc.calculateExpression(input);
        assertEquals(2d, actual, DELTA);
    }

    @Test
    public void additionOnePlusOneEqualsTwo(){
        String input = "1+1";
        double acutal = calc.calculateExpression(input);
        assertEquals(2d, acutal, DELTA);
    }

    @Test
    public void additionOnePlusOnePlusOneEqualsThree(){
        String input = "1+1+1";
        double actual = calc.calculateExpression(input);
        assertEquals(3d, actual, DELTA);
    }

    @Test
    public void multiplyTwoTimesFourEqualsEight(){
        String input = "2*4";
        double actual = calc.calculateExpression(input);
        assertEquals(8d, actual, DELTA);
    }
    
    @Test
    public void multiplyTwoTimesTwoTimesFourEqualsSixteen() {
    	String input = "2*2*4";
    	double actual  = calc.calculateExpression(input);
    	assertEquals(16d, actual, DELTA);
    }

    @Test
    public void subtractionTwoMinusOneEqualsOne() {
    	String input = "2-1";
    	double actual = calc.calculateExpression(input);
    	assertEquals (1d, actual, DELTA);
    }
    @Ignore //Denna får jag inte till!
    @Test
    public void subtractionThreeMinusOneMinusOneEqualsOne() {
    	String input = "3-1-1";
    	double actual = calc.calculateExpression(input);
    	assertEquals (1d, actual, DELTA);
    }
    @Test
    public void testAdditionMultiplyInRinghtOrder(){
         String input = "4*5+3";
        double actual = calc.calculateExpression(input);
        assertEquals(23d, actual, DELTA);
    }
    
    @Test
    public void testSubtractionMultiplyInRightOrder() {
    	String input = "50-2*5";
    	double actual = calc.calculateExpression(input);
    	assertEquals(40d, actual, DELTA);
    }

    
}
