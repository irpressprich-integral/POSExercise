package main;

import java.util.Map;

public class Catalog {

    private final Map<String, Long> barcodeByPrice;

    public Catalog(Map<String, Long> barcodeByPrice) {
        this.barcodeByPrice = barcodeByPrice;
    }

    public Long getPrice(String barcode) {
        return barcodeByPrice.get(barcode);
    }

    public boolean hasProduct(String barcode) {
        return barcodeByPrice.containsKey(barcode);
    }
}
