package org.example;

public enum Urls {
    BASE_URL("https://api.hypixel.net"),
    BAZAAR("/v2/skyblock/bazaar"),
    ;

    private String text;

    Urls(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return text;
    }
}
