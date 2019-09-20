package main;

public class Display {

    private String text;

    public String showText() {
        return text;
    }

    public void displayProductNotFound() {
        this.text = "Product not found";
    }

    public void displayProductNotScanned() {
        this.text = "Product not scanned";
    }

    public void displaySaleNotInProgress() {
        this.text = "No sale in progress.";
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayTotal(String totalPrice) {
        this.text = "Total: " + totalPrice;
    }
}
