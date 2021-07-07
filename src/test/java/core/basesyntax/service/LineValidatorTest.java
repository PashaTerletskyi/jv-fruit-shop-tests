package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import core.basesyntax.service.impl.LineValidatorImpl;
import org.junit.Before;
import org.junit.Test;

public class LineValidatorTest {
    private LineValidator lineValidator;

    @Before
    public void init() {
        lineValidator = new LineValidatorImpl();
    }

    @Test
    public void lineValidator_correctWork_ok() {
        String line = "b,banana,20";
        boolean expected = true;
        boolean actual = lineValidator.isValid(line);
        assertEquals(expected, actual);
    }

    @Test
    public void lineValidator_withOutOperation_notOk() {
        String line = "banana,20";
        boolean expected = false;
        boolean actual = lineValidator.isValid(line);
        assertEquals(expected, actual);
    }

    @Test
    public void lineValidator_withOutFruit_notOk() {
        String line = "b,,20";
        boolean expected = false;
        boolean actual = lineValidator.isValid(line);
        assertEquals(expected, actual);
    }

    @Test
    public void lineValidator_withOutQuantity_notOk() {
        String line = "b,banana,";
        boolean expected = false;
        boolean actual = lineValidator.isValid(line);
        assertEquals(expected, actual);
    }

    @Test
    public void lineValidator_emptyLine_notOk() {
        String line = "";
        boolean expected = false;
        boolean actual = lineValidator.isValid(line);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void lineValidator_Null_notOk() {
        String line = null;
        lineValidator.isValid(line);
    }
}
