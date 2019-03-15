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
    
    @Test(expected = ArithmeticException.class)
	 public void containsCharacters() {
		 String input = "400A00";
		 String actual = calc.calculateExpression(input);
		 assertEquals("String can not contain characters", actual);
	 }
 
    /** 
     * denna returnerar ,0 pga decimalfunktionem. Men utan den returnerar den 0.0
     * så jag vet inte vad som är fel faktiskt. Jag vet inte om jag kan nå owerflow
     * när den gör om från double till sträng och det är där det felar. 
     */
	 @Test
	 public void lookingForOverflow() {
		 String input = "1.7976931348623157E308";
		 String actual = calc.calculateExpression(input);
		 assertEquals("test", actual);
	 }
		
	
}
