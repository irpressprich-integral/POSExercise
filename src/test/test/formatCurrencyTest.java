package test;

import static junit.framework.TestCase.assertEquals;

import main.Sale;
import org.junit.Test;

public class formatCurrencyTest {

    @Test
    public void zeroCents() {
        assertEquals("$0.00", Sale.formatCurrency(0));
    }

    @Test
    public void hundredCents() {
        assertEquals("$1.00", Sale.formatCurrency(100));
    }

    @Test
    public void thousandCents() {
        assertEquals("$10.00", Sale.formatCurrency(1000));
    }

    @Test
    public void fiveCents() {
        assertEquals("$0.05", Sale.formatCurrency(5));
    }

    @Test
    public void tenCents() {
        assertEquals("$10.00", Sale.formatCurrency(1000));
    }

    @Test
    public void twoSeventyFiveCents() {
        assertEquals("$2.75", Sale.formatCurrency(275));
    }

    @Test
    public void oneCent() {
        assertEquals("$0.01", Sale.formatCurrency(1));
    }

    @Test
    public void oneHundredThousandCents() {
        assertEquals("$1,000.00", Sale.formatCurrency(100000));
    }

    @Test
    public void oneHundredMillonCent() {
        assertEquals("$1,000,000.00", Sale.formatCurrency(100000000));
    }
}
