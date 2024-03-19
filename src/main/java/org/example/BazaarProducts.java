package org.example;

public enum BazaarProducts {
    ENCHANTED_COBBLESTONE("ENCHANTED_COBBLESTONE", 800, 900);
    ;

    private String text;
    private double desiredBuyPrice;
    private double desiredSellPrice;

    BazaarProducts(String text, double desiredBuyPrice, double desiredSellPrice) {
        this.text = text;
        this.desiredBuyPrice = desiredBuyPrice;
        this.desiredSellPrice = desiredSellPrice;
    }

    @Override
    public String toString() {
        return text;
    }

    public double getDesiredBuyPrice() {
        return desiredBuyPrice;
    }

    public double getDesiredSellPrice() {
        return desiredSellPrice;
    }

    public String getText() {
        return text;
    }
}
