package test;

import static junit.framework.TestCase.assertEquals;

import java.util.HashMap;
import java.util.Map;
import main.Catalog;
import main.Display;
import main.Sale;
import org.junit.Before;
import org.junit.Test;

public class SingleSaleTest {

    private Map<String, Long> barcodeByPrice;
    private Display display;
    private Sale sale;
    private Catalog catalog;

    @Before
    public void setup() {
        display = new Display();
        barcodeByPrice = new HashMap<>() {{
            put("12345", 1225l);
            put("23456", 1265l);
        }};
        catalog = new Catalog(barcodeByPrice);
        sale = new Sale(display, catalog);
    }

    @Test
    public void lookUpBarcodeAndReturnPrice() {
        sale.onBarcode("12345");
        assertEquals("$12.25", display.showText());
    }

    @Test
    public void lookUpBarcode2AndReturnPrice() {
        sale.onBarcode("23456");
        assertEquals("$12.65", display.showText());
    }

    @Test
    public void barcodeNotFound() {
        sale.onBarcode("99999");
        assertEquals("Product not found", display.showText());
    }

    @Test
    public void nullBarcode() {
        sale.onBarcode(null);
        assertEquals("Product not scanned", display.showText());
    }

    @Test
    public void emptyBarcode() {
        sale.onBarcode("");
        assertEquals("Product not scanned", display.showText());
    }
}
