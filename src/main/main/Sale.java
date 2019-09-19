package main;

public class Sale {

    private final Display display;
    private Catalog catalog;
    private String price;
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

            double doublePrice = convertStringToDouble(price);
            totalPrice += doublePrice;
            display.displayPrice(price);
        } else {
            display.displayProductNotFound();
        }
    }

    private double convertStringToDouble(String price) {

        return Double.parseDouble(price.substring(1));
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
