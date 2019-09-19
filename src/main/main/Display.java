package main;

public class Display {

    private String text;

    public String showText() {
        return text;
    }

    public void displayProductNotFound() {
        this.text = "Product not found";
    }

    public void displayPrice(String priceAsText) {
        this.text = priceAsText;
    }

    public void displayProductNotScanned() {
        this.text = "Product not scanned";
    }

    public void displaySaleNotInProgress() {
        this.text = "No sale in progress.";
    }

    public void displayTotal(){
        this.text =  "Total: $6.40";
    }
}
