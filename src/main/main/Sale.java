package main;

public class Sale {

    private final Display display;
    private Catalog catalog;
    private Double price;
    private double totalPrice;

    public Sale(Display display, Catalog catalog) {
        this.display = display;
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        if (barcode == null || barcode.equals("")) {
            display.displayProductNotScanned();
            return;
        }

        if (catalog.hasProduct(barcode)) {
            price = catalog.getPrice(barcode);
            totalPrice += price;
            display.displayPrice(price);
        } else {
            display.displayProductNotFound();
        }
    }

    public void onTotal() {
        boolean saleInProgress = price != null;
        if (saleInProgress) {
            display.displayTotal(totalPrice);
        } else {
            display.displaySaleNotInProgress();
        }
    }
}
