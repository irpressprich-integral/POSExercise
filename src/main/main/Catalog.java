package main;

import java.util.Map;

public class Catalog {

    private final Map<String, Double> barcodeByPrice;

    public Catalog(Map<String, Double> barcodeByPrice) {
        this.barcodeByPrice = barcodeByPrice;
    }

    public Double getPrice(String barcode) {
        return barcodeByPrice.get(barcode);
    }

    public boolean hasProduct(String barcode) {
        return barcodeByPrice.containsKey(barcode);
    }
}
