package CalculatorTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Calculator.Calculator;

public class CalculatorMethodWithDoublesTests{


Calculator calc;

@Before
public void beforeEachTest() {
    calc = new Calculator();
}

@Test
public void additionOnePlusOneEqualsTwo(){
    Double acutal = calc.addition(1, 1);
    assertEquals(2,0d, acutal);
}

@Test
public void multiplyTwoTimesFourEqualsEight(){
    Double actual = calc.multiply(2,8);
    assertEquals(8,0d, actual);
}

@Test
public void subtractionTwoMinusOneEqualsOne() {
	Double actual = calc.subtraction(2, 1);
	assertEquals (1,0d, actual);
}

@Test
public void divisionSixDividedByTwoEqualsThree() {
	Double actual = calc.division(6, 2);
	assertEquals (3,0d, actual);
}

@Test
public void moduloSixModuloFourEqualsTwo() {
	Double actual = calc.modulo(6, 4);
	assertEquals (2,0d, actual);
}

@Test
public void factorialFive(){
    Double actual = calc.factorial(5);
    assertEquals(120,0d, actual);
}

}