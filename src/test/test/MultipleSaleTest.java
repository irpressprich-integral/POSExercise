package test;

import static junit.framework.TestCase.assertEquals;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import main.Catalog;
import main.Display;
import main.Sale;
import org.junit.Before;
import org.junit.Test;

public class MultipleSaleTest {

    private Display display;
    private Map barcodeByPriceMap;

    @Before
    public void setUp() throws Exception {
        display = new Display();
        barcodeByPriceMap = new HashMap<String, Long>() {{
            put("12345", 1000l);
            put("11111", 1500l);
            put("22222", 2000l);
        }};
    }

    @Test
    public void zeroItems() {
        Sale sale = new Sale(display, null);

        sale.onTotal();
        assertEquals("No sale in progress.", display.showText());
    }

    @Test
    public void oneItemFound() {
        Sale sale = new Sale(display, new Catalog(Collections.singletonMap("12345", 640l)));

        sale.onBarcode("12345");
        sale.onTotal();

        assertEquals("Total: $6.40", display.showText());
    }

    @Test
    public void oneItemNotFound() {
        Sale sale = new Sale(display, new Catalog(Collections.singletonMap("12345", 640l)));

        sale.onBarcode("99999");
        sale.onTotal();

        assertEquals("No sale in progress.", display.showText());
    }

    @Test
    public void threeItemsFound() {
        Sale sale = new Sale(display, new Catalog(barcodeByPriceMap));
        sale.onBarcode("12345");
        sale.onBarcode("11111");
        sale.onBarcode("22222");

        sale.onTotal();

        assertEquals("Total: $45.00", display.showText());
    }
}
