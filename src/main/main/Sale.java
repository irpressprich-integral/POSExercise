package main;

import java.util.ArrayList;
import java.util.Collection;

public class Sale {

    private final Display display;
    private Catalog catalog;
    private long totalPrice;
    private Collection<Long> scannedPricesList;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
        scannedPricesList = new ArrayList<>();
    }

    public static String formatCurrency(long priceInCents) {
        return String.format("$%,.2f", priceInCents / 100.0);
    }

    public void onBarcode(String barcode) {
        if (barcode == null || barcode.equals("")) {
            display.displayProductNotScanned();
            return;
        }

        if (catalog.hasProduct(barcode)) {
            long price = catalog.getPrice(barcode);
            scannedPricesList.add(price);

            display.displayPrice(formatCurrency(price));
        } else {
            display.displayProductNotFound();
        }
    }

    public void onTotal() {
        if (scannedPricesList.size() != 0) {
            totalPrice = scannedPricesList.stream().reduce((long) 0, Long::sum);
            display.displayTotal(formatCurrency(totalPrice));
        } else {
            display.displaySaleNotInProgress();
        }
    }
}
