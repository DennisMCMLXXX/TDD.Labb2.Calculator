package CalcylatorTest;

import Calcylator.Calcylator;
import org.junit.*;


import static org.junit.Assert.assertEquals;

public class CalcylatorTest{


    @Before
    public void init() {

    }

    @Ignore
    @Test
    public void featureTestAdditinMultiplySubtractionInRinghtOrder(){
        Calcylator calc = new Calcylator();
        String input = "3+4*5-6";
        double acual = calc.calculateExpression(input);
        assertEquals(17d, acual, 0.111 );
    }

    @Test
    public void StringOfOneToDoubleOne(){
        Calcylator calc = new Calcylator();
        String input = "1";
        double actual = calc.calculateExpression(input);
        assertEquals(1d, actual, 0.111);
    }

    @Test
    public void StringOfTwoGivesDoubleTwo(){
        Calcylator calc = new Calcylator();
        String input = "2";
        double actual = calc.calculateExpression(input);
        assertEquals(2d, actual, 0.111);
    }


}
