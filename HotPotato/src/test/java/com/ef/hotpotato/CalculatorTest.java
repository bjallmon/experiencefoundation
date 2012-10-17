package com.ef.hotpotato;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    @Test
    public void addString() {
        assertEquals("105", Calculator.calculate("3+2+100"));
    }

    @Test
    public void subtractString() {
        assertEquals("48", Calculator.calculate("100-50-2"));
    }

    @Test
    public void subtractInFrontShouldCalculate() {
        assertEquals("50", Calculator.calculate("-50+100"));
    }
    @Test
    public void shouldBeAbleToAddAndSubtract() {
        assertEquals("1000", Calculator.calculate("1000-50-0+100+0-50"));
    }

    @Test
    public void shouldMultiplyTwoIntegers() {
            assertEquals("36", Calculator.calculate("6*6"));
    }

    @Test
    public void shouldHandleAllOperators()  {
            assertEquals("2" , Calculator.calculate("7*2+12-4/10"));
    }
    @Test
    public void shouldMultiplyThreeIntegers()  {
            assertEquals("16", Calculator.calculate("2*4*2"));
    }
    @Test
    public void shouldDivide()  {
            assertEquals("6", Calculator.calculate("36/6"));
    }

    @Test public void shouldDivide3Integers() {
        assertEquals("2", Calculator.calculate("100/25/2"));
    }
}
