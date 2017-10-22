package com.epam.androidtraining;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;

import java.util.regex.Matcher;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public abstract class CalculatorTest {


    private ICalculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = createCalculator();
    }

    abstract ICalculator createCalculator();

    @Test
    public void testAdd() {
        String input = "1+2";
        assertEquals("3", mCalculator.evaluate(input));

        final String result = mCalculator.add(1,2);
        assertEquals("3", result);
        doReturn("5").when(mCalculator).evaluate(Matchers.anyString());
//        when(mCalculator.evaluate(Matchers.anyString())).thenReturn("5");
        assertEquals("5", mCalculator.evaluate(Matchers.anyString()));
    }


}