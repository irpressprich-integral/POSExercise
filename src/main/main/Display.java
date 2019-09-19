package main;

import java.text.DecimalFormat;

public class Display {

    private String text;

    public String showText() {
        return text;
    }

    public void displayProductNotFound() {
        this.text = "Product not found";
    }

    public void displayPrice(long price) {
        this.text = String.format("$%.2f", price / 100.0);
    }

    public void displayProductNotScanned() {
        this.text = "Product not scanned";
    }

    public void displaySaleNotInProgress() {
        this.text = "No sale in progress.";
    }

    public void displayTotal(long totalPrice) {
        this.text = "Total: $" + String.format("%.2f", totalPrice / 100.0);
    }
}
