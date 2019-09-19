package main;

import java.util.Map;

public class Catalog {

    private final Map<String, String> barcodeByPrice;

    public Catalog(Map<String, String> barcodeByPrice) {
        this.barcodeByPrice = barcodeByPrice;
    }

    public String getPrice(String barcode){
        return barcodeByPrice.get(barcode);
    }

    public boolean hasProduct(String barcode) {
        return barcodeByPrice.containsKey(barcode);
    }
}
