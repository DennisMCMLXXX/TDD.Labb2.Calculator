package CalcylatorTest;

import Calcylator.Calcylator;
import org.junit.*;


import static org.junit.Assert.assertEquals;

public class CalcylatorTest{

    private static final double DELTA = 0.111;

    Calcylator calc;

    @Before
    public void beforeEachTest() {
        calc = new Calcylator();
    }

    @Ignore
    @Test
    public void featureTestAdditinMultiplySubtractionInRinghtOrder(){
         String input = "3+4*5-6";
        double acual = calc.calculateExpression(input);
        assertEquals(17d, acual, DELTA);
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
    public void AdditionOnePlusOneEqualsTwo(){
        String input = "1+1";
        double acutal = calc.calculateExpression(input);
        assertEquals(2d, acutal, DELTA);
    }

}
