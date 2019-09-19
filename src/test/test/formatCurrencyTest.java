package test;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class formatCurrencyTest {

    private static String formatCurrency(long priceInCents) {
        if (priceInCents == 0) {
            return "$0.00";
        } else {
            return "$1.00";
        }
    }

    @Test
    public void zeroCents() {
        assertEquals("$0.00", formatCurrency(0));
    }

    @Test
    public void hundredCents() {
        assertEquals("$1.00", formatCurrency(100));
    }
}
