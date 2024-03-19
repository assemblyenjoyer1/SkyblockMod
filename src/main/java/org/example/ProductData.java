package org.example;

import java.util.List;
import java.util.Map;

public class ProductData {
    private boolean success;
    private long lastUpdated;
    private Map<String, Product> products;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }

    public static class Product {
        private String product_id;
        private List<SellSummary> sell_summary;
        private List<BuySummary> buy_summary;
        private QuickStatus quick_status;

        public String getProduct_id() {
            return product_id;
        }

        public void setProduct_id(String product_id) {
            this.product_id = product_id;
        }

        public List<SellSummary> getSell_summary() {
            return sell_summary;
        }

        public void setSell_summary(List<SellSummary> sell_summary) {
            this.sell_summary = sell_summary;
        }

        public List<BuySummary> getBuy_summary() {
            return buy_summary;
        }

        public void setBuy_summary(List<BuySummary> buy_summary) {
            this.buy_summary = buy_summary;
        }

        public QuickStatus getQuick_status() {
            return quick_status;
        }

        public void setQuick_status(QuickStatus quick_status) {
            this.quick_status = quick_status;
        }
    }

    public static class SellSummary {
        private int amount;
        private double pricePerUnit;
        private int orders;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public void setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
        }

        public int getOrders() {
            return orders;
        }

        public void setOrders(int orders) {
            this.orders = orders;
        }
    }

    public static class BuySummary {
        private int amount;
        private double pricePerUnit;
        private int orders;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public double getPricePerUnit() {
            return pricePerUnit;
        }

        public void setPricePerUnit(double pricePerUnit) {
            this.pricePerUnit = pricePerUnit;
        }

        public int getOrders() {
            return orders;
        }

        public void setOrders(int orders) {
            this.orders = orders;
        }
    }

    public static class QuickStatus {
        private String productId;
        private double sellPrice;
        private int sellVolume;
        private long sellMovingWeek;
        private int sellOrders;
        private double buyPrice;
        private int buyVolume;
        private long buyMovingWeek;
        private int buyOrders;

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public double getSellPrice() {
            return sellPrice;
        }

        public void setSellPrice(double sellPrice) {
            this.sellPrice = sellPrice;
        }

        public int getSellVolume() {
            return sellVolume;
        }

        public void setSellVolume(int sellVolume) {
            this.sellVolume = sellVolume;
        }

        public long getSellMovingWeek() {
            return sellMovingWeek;
        }

        public void setSellMovingWeek(long sellMovingWeek) {
            this.sellMovingWeek = sellMovingWeek;
        }

        public int getSellOrders() {
            return sellOrders;
        }

        public void setSellOrders(int sellOrders) {
            this.sellOrders = sellOrders;
        }

        public double getBuyPrice() {
            return buyPrice;
        }

        public void setBuyPrice(double buyPrice) {
            this.buyPrice = buyPrice;
        }

        public int getBuyVolume() {
            return buyVolume;
        }

        public void setBuyVolume(int buyVolume) {
            this.buyVolume = buyVolume;
        }

        public long getBuyMovingWeek() {
            return buyMovingWeek;
        }

        public void setBuyMovingWeek(long buyMovingWeek) {
            this.buyMovingWeek = buyMovingWeek;
        }

        public int getBuyOrders() {
            return buyOrders;
        }

        public void setBuyOrders(int buyOrders) {
            this.buyOrders = buyOrders;
        }
    }
}

