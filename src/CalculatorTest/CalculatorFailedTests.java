package CalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Calculator.Calculator;

public class CalculatorFailedTests {

    Calculator calc;

    @Before
    public void beforeEachTest() {
        calc = new Calculator();
    }
    @Ignore
    @Test
    public void divisionTwentyByTwoByFiveEqualsTwo() {
    	String input = "20/2/5";
    	String actual = calc.calculateExpression(input);
    	assertEquals ("2.0", actual);
    }
}
