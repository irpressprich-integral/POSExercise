package test;

import static junit.framework.TestCase.assertEquals;

import java.text.NumberFormat;
import java.util.Locale;
import org.junit.Test;

public class formatCurrencyTest {

    private static String formatCurrency(long priceInCents) {
        NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
        return n.format(priceInCents / 100.0);
    }

    @Test
    public void zeroCents() {
        assertEquals("$0.00", formatCurrency(0));
    }

    @Test
    public void hundredCents() {
        assertEquals("$1.00", formatCurrency(100));
    }

    @Test
    public void thousandCents() {
        assertEquals("$10.00", formatCurrency(1000));
    }

    @Test
    public void fiveCents() {
        assertEquals("$0.05", formatCurrency(5));
    }

    @Test
    public void tenCents() {
        assertEquals("$10.00", formatCurrency(1000));
    }

    @Test
    public void twoSeventyFiveCents() {
        assertEquals("$2.75", formatCurrency(275));
    }

    @Test
    public void oneCent() {
        assertEquals("$0.01", formatCurrency(1));
    }

    @Test
    public void oneHundredThousandCents() {
        assertEquals("$1,000.00", formatCurrency(100000));
    }

    @Test
    public void oneHundredMillonCent() {
        assertEquals("$1,000,000.00", formatCurrency(100000000));
    }
}
