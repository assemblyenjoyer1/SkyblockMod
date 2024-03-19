package org.example;

public class Product {

    private String name;
    private double buyPrice;
    private double sellPrice;

    private double desiredBuyPrice;
    private double desiredSellPrice;

    public Product(String name, double buyPrice, double sellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
    }

    public Product(String name, double buyPrice, double sellPrice, double desiredBuyPrice, double desiredSellPrice) {
        this.name = name;
        this.buyPrice = buyPrice;
        this.sellPrice = sellPrice;
        this.desiredBuyPrice = desiredBuyPrice;
        this.desiredSellPrice = desiredSellPrice;
    }

    public String getName() {
        return name;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", buyPrice=" + buyPrice +
                ", sellPrice=" + sellPrice +
                '}';
    }

    public double getDesiredBuyPrice() {
        return desiredBuyPrice;
    }

    public double getDesiredSellPrice() {
        return desiredSellPrice;
    }

    public void setDesiredBuyPrice(double desiredBuyPrice) {
        this.desiredBuyPrice = desiredBuyPrice;
    }

    public void setDesiredSellPrice(double desiredSellPrice) {
        this.desiredSellPrice = desiredSellPrice;
    }
}
