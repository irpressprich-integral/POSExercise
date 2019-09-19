package test;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import javax.security.sasl.Sasl;
import main.Catalog;
import main.Display;
import main.Sale;
import org.junit.Test;

public class MultipleSaleTest {

    @Test
    public void zeroItems() {
        Display display = new Display();
        Sale sale = new Sale(display, null);

        sale.onTotal();
        assertEquals("No sale in progress.", display.showText());
    }

    @Test
    public void oneItemFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new Catalog(Collections.singletonMap("12345","$6.40")));

        sale.onBarcode("12345");
        sale.onTotal();

        assertEquals("Total: $6.40", display.showText());
    }

    @Test
    public void oneItemNotFound() {
        Display display = new Display();
        Sale sale = new Sale(display, new Catalog(Collections.singletonMap("12345","$6.40")));

        sale.onBarcode("99999");
        sale.onTotal();

        assertEquals("No sale in progress.", display.showText());
    }

    @Test
    public void barcodeEmpty() {

    }
}
