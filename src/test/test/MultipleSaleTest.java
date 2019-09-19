package test;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import main.Catalog;
import main.Display;
import main.Sale;
import org.junit.Ignore;
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
    @Ignore
    public void barcodeEmpty() {

    }

    @Test
    public void threeItemsFound() {
        Display display = new Display();
        Map catalog = new HashMap<String, String>(){{
            put("12345", "$10.00");
            put("11111", "$15.00");
            put("22222", "$20.00");
        }};
        Sale sale = new Sale(display, new Catalog(catalog));
        sale.onBarcode("12345");
        sale.onBarcode("11111");
        sale.onBarcode("22222");

        sale.onTotal();

        assertEquals("Total: $45.00", display.showText());
    }
}
