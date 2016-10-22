package com.xiumeteo.oktobertalks;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LambdaExampleTest {

    @Test
    public void testSquareWithAnonymous(){
        Squared squared = new Squared() {
            @Override
            public double square(double base) {
                return base * base;
            }
        };

        assertEquals( 9.0, squared.square(3.0), 0.005 );
    }

    @Test
    public void testSquareWithLambda(){
        Squared squared = base -> base * base;

        assertEquals( 9.0, squared.square(3.0), 0.005 );
    }


    @Test
    public void testSquareWithMethodReference(){
        Squared squared = new SquareCalculator();

        assertEquals( 9.0, squared.square(3.0), 0.005 );
    }

}
